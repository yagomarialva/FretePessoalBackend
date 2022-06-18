package com.unnt.fretepessoal.repository;

import com.unnt.fretepessoal.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository  extends JpaRepository<Transacao, Long> {

}
