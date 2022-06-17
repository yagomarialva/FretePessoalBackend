package com.unnt.fretepessoal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class NewUserDTO implements Serializable {
    public static final long serialVersionUID = 1L;


    //    @NotEmpty(message = "Preenchimento obrigatório")
//    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 à 120 caracteres.")
    private String name;

    //    @NotEmpty(message = "Preenchimento obrigatório")
//    @Email(message = "Email inválido.")
    private String email;

    //    @NotEmpty(message = "Preenchimento obrigatório")
    private String cpf;

    private String phone;

    private String city;

    private String uf;

    private String birthDate;

    private String cep;

    private String address;

//    private Integer typeUser;

    //    @NotEmpty(message = "Preenchimento obrigatório")
    private String password;

}
