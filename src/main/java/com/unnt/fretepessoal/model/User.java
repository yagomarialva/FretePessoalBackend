package com.unnt.fretepessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unnt.fretepessoal.model.enums.Profile;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PROFILES")
    private Set<Integer> profiles = new HashSet<>();

    public User(){
        addProfile(Profile.CLIENT);
    }

    public User(Integer id, String name, String email, String cpf, String password){
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        addProfile(Profile.CLIENT);
    }

    public Set<Profile> getProfiles(){
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        profiles.add(profile.getNumber());
    }
}
