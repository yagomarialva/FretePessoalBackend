package com.unnt.fretepessoal.model;

import com.unnt.fretepessoal.model.enums.PacoteStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pacote")
@Data
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String descricao;

    private String icone;

    private String origem;

    private String destino;

    private Date dataCriacao;

    private Date dataOrigem;

    private Date dataDestino;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dono_id", nullable = false)
    private User dono;

    @ManyToOne()
    @JoinColumn(name = "transacao_id")
    private Transacao transacao;

    @Enumerated(EnumType.STRING)
    private PacoteStatus status;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private BigDecimal preco;

    public Pacote() {
        this.dataCriacao = new Date();
        this.code = ("" + this.dataCriacao.getTime())
            .substring(7) + "PCT";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pacote other = (Pacote) obj;
        return Objects.equals(id, other.id);
    }


}
