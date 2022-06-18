package com.unnt.fretepessoal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unnt.fretepessoal.model.enums.TransacaoStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transacao")
@Data
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataCriacao;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "viajante_id", nullable = false)
    private User viajante;

    @OneToMany(mappedBy = "transacao")
    private List<Pacote> pacotes;

    @Enumerated(EnumType.STRING)
    private TransacaoStatus status;

    private Date dataOrigem;

    private Date dataDestino;

    private BigDecimal preco;

    private Double peso;

    private String origem;

    private String destino;

    public Transacao() {
        this.dataCriacao = new Date();
        this.code = ("" + this.dataCriacao.getTime())
                .substring(7) + "RT";
    }
}
