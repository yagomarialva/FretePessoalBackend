package com.unnt.fretepessoal.repository;

import com.unnt.fretepessoal.model.Transacao;
import com.unnt.fretepessoal.model.enums.TransacaoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository  extends JpaRepository<Transacao, Long> {

    @Query("SELECT a FROM Transacao a " +
            "inner join a.viajante d " +
                "WHERE d.name LIKE ?1 " +
                    "OR a.code LIKE ?1 " +
                "ORDER BY a.dataCriacao DESC")
    List<Transacao> findAllByQuery(String s);

    Transacao findByViajante_idAndStatus(Integer id, TransacaoStatus status);

    List<Transacao> findAllByViajante_id(Integer id);

}
