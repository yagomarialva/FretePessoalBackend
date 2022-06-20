package com.unnt.fretepessoal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unnt.fretepessoal.model.Pacote;
import com.unnt.fretepessoal.model.enums.PacoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacoteDTO implements Serializable {

    private Long id;
    private String code;
    private String descricao;
    private String icone;
    private Long origem;
    private Long destino;
    private Integer dono;
    private PacoteStatus status;
    private Double peso;
    private BigDecimal preco;
    private String nomeOrigem;
    private String nomeDestino;
    private String nomeDono;
    private String nomeViajante;
    private String codeTransacao;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataCriacao;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataEntrega;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataOrigem;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataDestino;

    public PacoteDTO(Pacote pacote) {
        this.id = pacote.getId();
        this.code = pacote.getCode();
        this.descricao = pacote.getDescricao();
        this.icone = pacote.getIcone();
        this.origem = pacote.getOrigem().getId();
        this.destino = pacote.getDestino().getId();
        this.dono = pacote.getDono().getId();
        this.status = pacote.getStatus();
        this.peso = pacote.getPeso();
        this.preco = pacote.getPreco();

        this.nomeOrigem = pacote.getOrigem().getName();
        this.nomeDestino = pacote.getDestino().getName();
        this.nomeDono = pacote.getDono().getName();

        this.dataCriacao = pacote.getDataCriacao();
        this.dataOrigem = pacote.getDataOrigem();
        this.dataDestino = pacote.getDataDestino();
        this.dataEntrega = pacote.getDataEntrega();

        if (pacote.getTransacao() != null) {
            this.nomeViajante = pacote.getTransacao().getViajante().getName();
            this.codeTransacao = pacote.getTransacao().getCode();
        }
    }

}
