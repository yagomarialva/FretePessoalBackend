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

    private String name;

    private String email;

    private String cpf;

    private String phone;

    public UserDTO(User cliente){
        this.id = cliente.getId();
        this.name = cliente.getName();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
        this.phone = cliente.getPhone();
    }
}
