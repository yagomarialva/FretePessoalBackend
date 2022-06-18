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
    private String origem;
    private String destino;
    private Integer dono;
    private String nomeDono;
    private PacoteStatus status;
    private Double peso;
    private BigDecimal preco;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataCriacao;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataOrigem;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataDestino;

    public PacoteDTO(Pacote pacote) {
        this.id = pacote.getId();
        this.code = pacote.getCode();
        this.descricao = pacote.getDescricao();
        this.icone = pacote.getIcone();
        this.origem = pacote.getOrigem();
        this.destino = pacote.getDestino();
        this.dono = pacote.getDono().getId();
        this.nomeDono = pacote.getDono().getName();
        this.status = pacote.getStatus();
        this.peso = pacote.getPeso();
        this.preco = pacote.getPreco();

        this.dataCriacao = pacote.getDataCriacao();
        this.dataOrigem = pacote.getDataOrigem();
        this.dataDestino = pacote.getDataDestino();
    }

}
