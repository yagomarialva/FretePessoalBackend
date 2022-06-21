package com.unnt.fretepessoal.services;

import com.unnt.fretepessoal.dto.TransacaoDTO;
import com.unnt.fretepessoal.model.City;
import com.unnt.fretepessoal.model.Pacote;
import com.unnt.fretepessoal.model.Transacao;
import com.unnt.fretepessoal.model.enums.PacoteStatus;
import com.unnt.fretepessoal.model.enums.TransacaoStatus;
import com.unnt.fretepessoal.repository.PacoteRepository;
import com.unnt.fretepessoal.repository.TransacaoRepository;
import com.unnt.fretepessoal.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepo;

    @Autowired
    private PacoteRepository pacoteRepo;

    @Autowired
    private UserRepository userRepo;

    @Transactional
    public List<TransacaoDTO> list(String query) {
        return (StringUtils.isEmpty(query)
            ? transacaoRepo.findAll(Sort.by(Sort.Direction.DESC, "dataCriacao"))
            : transacaoRepo.findAllByQuery('%' + query + '%')
        ).stream()
                .map(TransacaoDTO::new)
                .collect(toList());
    }

    @Transactional
    public TransacaoDTO save(Long id, TransacaoDTO toSave) {
        Transacao model = (id == null) ? new Transacao() : transacaoRepo.getById(id);

        model.setOrigem(new City(toSave.getOrigem()));
        model.setDestino(new City(toSave.getDestino()));
        model.setViajante(userRepo.getById(toSave.getViajante()));
        model.setStatus(toSave.getStatus());
        model.setPeso(toSave.getPeso());
        model.setPreco(toSave.getPreco());
        model.setDataOrigem(toSave.getDataOrigem());
        model.setDataDestino(toSave.getDataDestino());

        updatePacotes(model, toSave);

        TransacaoStatus newStatus = model.getPacotes().stream().anyMatch(it ->
                it.getStatus().equals(PacoteStatus.A_CAMINHO))
                ? TransacaoStatus.PENDENTE : TransacaoStatus.COMPLETO;
        if (!model.getStatus().equals(TransacaoStatus.COMPLETO) &&
                newStatus.equals(TransacaoStatus.COMPLETO)) {
            model.setDataEntrega(new Date());
        }
        model.setStatus(newStatus);

        return new TransacaoDTO(transacaoRepo.save(model));
    }

    private void updatePacotes(Transacao transacao, TransacaoDTO toSave) {
        List<Pacote> pacotes = new ArrayList<>();
        toSave.getPacotes().forEach(it -> {
            Pacote pacote = pacoteRepo.getById(it.getId());
            if (pacote.getStatus().ordinal() < PacoteStatus.ENTREGUE.ordinal()) {
                pacote.setDataOrigem(toSave.getDataOrigem());
                pacote.setDataDestino(toSave.getDataDestino());
                pacote.setTransacao(transacao);
                pacote.setStatus(
                        it.getStatus().equals(TransacaoStatus.COMPLETO)
                                ? PacoteStatus.ENTREGUE : PacoteStatus.A_CAMINHO
                );
                pacote = pacoteRepo.save(pacote);
            }
            pacotes.add(pacote);
        });
        transacao.setPacotes(pacotes);
    }

    public TransacaoDTO getOne(Long id) {
        return new TransacaoDTO(transacaoRepo.getById(id));
    }

    public TransacaoDTO getAtual(Integer userId) {
        Transacao transacao = transacaoRepo.findByViajante_idAndStatus(userId, TransacaoStatus.PENDENTE);
        return transacao == null ? null : new TransacaoDTO(transacao);
    }

    public List<TransacaoDTO> getHistorico(Integer userId) {
        return transacaoRepo.findAllByViajante_id(userId)
            .stream()
            .map(TransacaoDTO::new)
            .collect(toList());
    }
}
