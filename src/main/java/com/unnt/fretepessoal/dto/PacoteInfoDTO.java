package com.unnt.fretepessoal.dto;

import com.unnt.fretepessoal.model.Pacote;
import com.unnt.fretepessoal.model.enums.PacoteStatus;
import com.unnt.fretepessoal.model.enums.TransacaoStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PacoteInfoDTO {

    private Long id;
    private String code;
    private String dono;
    private Double peso;
    private BigDecimal preco;
    private TransacaoStatus status;

    public PacoteInfoDTO() {}

    public PacoteInfoDTO(Pacote pacote) {
        this.id = pacote.getId();
        this.code = pacote.getCode();
        this.dono = pacote.getDono().getName();
        this.peso = pacote.getPeso();
        this.preco = pacote.getPreco();
        this.status = pacote.getStatus().ordinal() < PacoteStatus.ENTREGUE.ordinal()
                ? TransacaoStatus.PENDENTE : TransacaoStatus.COMPLETO;
    }

}
