package com.unnt.fretepessoal.dto;

import com.unnt.fretepessoal.model.Pacote;
import com.unnt.fretepessoal.model.enums.PacoteStatus;
import com.unnt.fretepessoal.model.enums.TransacaoStatus;
import lombok.Data;

@Data
public class PacoteInfoDTO {

    private Long id;
    private String code;
    private String dono;
    private Double peso;
    private String status;

    public PacoteInfoDTO() {}

    public PacoteInfoDTO(Pacote pacote) {
        this.id = pacote.getId();
        this.code = pacote.getCode();
        this.dono = pacote.getDono().getName();
        this.peso = pacote.getPeso();
        this.status = pacote.getStatus().ordinal() < PacoteStatus.ENTREGUE.ordinal()
                ? TransacaoStatus.VIAJANDO.name()
                : TransacaoStatus.CONCLUIDO.name();
    }

}
