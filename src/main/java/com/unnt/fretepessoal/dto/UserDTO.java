package com.unnt.fretepessoal.dto;

import com.unnt.fretepessoal.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {
    public static final long serialVersionUID = 1L;

    private Integer id;

//    @NotEmpty(message = "Preenchimento obrigatório")
//    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 à 120 caracteres.")
    private String name;

//    @NotEmpty(message = "Preenchimento obrigatório")
//    @Email(message = "Email inválido.")
    private String email;

    public UserDTO(User cliente){
        this.id = cliente.getId();
        this.name = cliente.getName();
        this.email = cliente.getEmail();
    }
}
