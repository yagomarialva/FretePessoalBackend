package com.unnt.fretepessoal.repository;

import com.unnt.fretepessoal.dto.PacoteDTO;
import com.unnt.fretepessoal.model.enums.PacoteStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unnt.fretepessoal.model.Pacote;

import java.util.Arrays;
import java.util.List;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {

    @Query("SELECT a FROM Pacote a " +
                "inner join a.dono d " +
                    "WHERE d.name LIKE ?1 " +
                    "OR a.code LIKE ?1 " +
                "ORDER BY a.dataCriacao DESC")
    List<Pacote> findAllByQuery(String s);

    List<Pacote> findByStatus(PacoteStatus status);

    List<Pacote> findByStatusAndOrigem_idAndDestino_id(PacoteStatus status, Long origem, Long destino);

    List<Pacote> findByDono_idAndStatusNot(Integer userId, PacoteStatus finalizado);

    List<Pacote> findByDono_id(Integer userId);

    @Query("SELECT COUNT(p) FROM Pacote p WHERE p.status=?1")
    Integer findTotalByStatus(PacoteStatus status);
}
