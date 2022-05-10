package com.unnt.fretepessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unnt.fretepessoal.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {

}
