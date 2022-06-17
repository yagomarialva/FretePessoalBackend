package com.unnt.fretepessoal.model.enums;

import lombok.Getter;

@Getter
public enum Profile {
    ADMIN(1, "ROLE_ADMIN"),
    CLIENT(2, "ROLE_CLIENT");

    private final Integer number;
    private final String description;

    Profile(Integer number, String description) {
        this.number = number;
        this.description = description;
    }

    public static Profile toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (Profile x : Profile.values()){
            if (cod.equals(x.getNumber())){
                return x;
            }
        }

        throw new IllegalArgumentException("O id" + cod + " é inválido.");
    }
}
