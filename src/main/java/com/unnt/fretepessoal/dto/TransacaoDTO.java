package com.unnt.fretepessoal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unnt.fretepessoal.model.Transacao;
import com.unnt.fretepessoal.model.enums.TransacaoStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TransacaoDTO {

    private Long id;
    private String code;
    private Long origem;
    private Long destino;
    private Integer viajante;
    private TransacaoStatus status;
    private Integer qtd;
    private BigDecimal preco;
    private Double peso;
    private List<PacoteInfoDTO> pacotes;

    private String nomeOrigem;
    private String nomeDestino;
    private String nomeViajante;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataCriacao;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataEntrega;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataOrigem;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataDestino;

    public TransacaoDTO(Transacao transacao) {
        this.id = transacao.getId();
        this.code = transacao.getCode();
        this.dataCriacao = transacao.getDataCriacao();
        this.dataEntrega = transacao.getDataEntrega();
        this.dataOrigem = transacao.getDataOrigem();
        this.dataDestino = transacao.getDataDestino();
        this.viajante = transacao.getViajante().getId();

        this.origem = transacao.getOrigem().getId();
        this.destino = transacao.getDestino().getId();
        this.nomeOrigem = transacao.getOrigem().getName();
        this.nomeDestino = transacao.getDestino().getName();
        this.nomeViajante = transacao.getViajante().getName();

        this.status = transacao.getStatus();
        this.preco = transacao.getPreco();
        this.peso = transacao.getPeso();
        this.qtd = transacao.getPacotes().size();
        this.pacotes = transacao.getPacotes()
            .stream()
            .map(PacoteInfoDTO::new)
            .collect(Collectors.toList());
    }

}
