package com.unnt.fretepessoal.services;

import com.unnt.fretepessoal.dto.PacoteDTO;
import com.unnt.fretepessoal.model.City;
import com.unnt.fretepessoal.model.Pacote;
import com.unnt.fretepessoal.model.enums.PacoteStatus;
import com.unnt.fretepessoal.repository.PacoteRepository;
import com.unnt.fretepessoal.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository repo;

    @Autowired
    private UserRepository userRepo;

    public List<PacoteDTO> litarDisponiveis(Long origem, Long destino) {
        return repo.findByStatusAndOrigem_idAndDestino_id(PacoteStatus.NOVO_PACOTE, origem, destino)
                .stream()
                .map(PacoteDTO::new)
                .collect(Collectors.toList());
    }

    public List<PacoteDTO> listNovosPacotes() {
        return repo.findByStatus(PacoteStatus.NOVO_PACOTE)
            .stream()
            .map(PacoteDTO::new)
            .collect(Collectors.toList());
    }

    public List<PacoteDTO> list(String query) {
        return (StringUtils.isEmpty(query)
                ? repo.findAll() : repo.findAllByQuery('%' + query + '%')
        ).stream()
                .map(PacoteDTO::new)
                .collect(Collectors.toList());
    }

    public PacoteDTO save(Long id, PacoteDTO aPackage) {
        Pacote pack = (id == null)
                ? new Pacote()
                : repo.getById(id);

        pack.setDescricao(aPackage.getDescricao());
        pack.setIcone(aPackage.getIcone());
        pack.setOrigem(new City(aPackage.getOrigem()));
        pack.setDestino(new City(aPackage.getDestino()));
        pack.setDono(userRepo.getById(aPackage.getDono()));

        if (pack.getStatus() != null &&
            pack.getStatus().ordinal() < PacoteStatus.FINALIZADO.ordinal() &&
            aPackage.getStatus().equals(PacoteStatus.FINALIZADO)) {
            pack.setDataEntrega(new Date());
        }

        pack.setStatus(aPackage.getStatus());

        pack.setPeso(aPackage.getPeso());
        pack.setPreco(aPackage.getPreco());

        return new PacoteDTO(repo.save(pack));
    }

    public PacoteDTO getOne(Long id) {
        return new PacoteDTO(repo.getById(id));
    }

}
