package com.unnt.fretepessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class User implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private String cpf;

//    private Integer tipoCliente;

    @JsonIgnore
    private String password;

    public User(){}

    public User(Integer id, String name, String email, String cpf, String password){
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }
}
