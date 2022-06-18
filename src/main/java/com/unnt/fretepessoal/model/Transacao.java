package com.unnt.fretepessoal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unnt.fretepessoal.model.enums.TransacaoStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transacao")
@Data
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private java.util.Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "viajante_id", nullable = false)
    private User viajante;

    @OneToMany(mappedBy = "transacao")
    private List<Pacote> pacotes;

    @Enumerated(EnumType.STRING)
    private TransacaoStatus status;

    private Date dataSaida;

    private Date dataChegada;

    private String saida;

    private String chegada;

    public Transacao() {
        dataCriacao = new Date();
    }

}
