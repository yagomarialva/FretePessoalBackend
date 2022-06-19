package com.unnt.fretepessoal.repository;

import com.unnt.fretepessoal.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository  extends JpaRepository<Transacao, Long> {

    @Query("SELECT a FROM Transacao a " +
            "inner join a.viajante d " +
                "WHERE d.name LIKE ?1 " +
                "OR a.code LIKE ?1 ")
    List<Transacao> findAllByQuery(String s);

}
