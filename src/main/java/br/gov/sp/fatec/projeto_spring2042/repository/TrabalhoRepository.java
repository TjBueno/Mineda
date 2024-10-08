package br.gov.sp.fatec.projeto_spring2042.repository;

import br.gov.sp.fatec.projeto_spring2042.entity.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    @Query("SELECT t FROM Trabalho t WHERE t.titulo LIKE %:palavra% AND t.nota > :nota")
    List<Trabalho> findByTituloContainingAndNotaGreaterThan(@Param("palavra") String palavra, @Param("nota") Integer nota);
}