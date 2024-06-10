package com.kleyton.gerenciador_de_pautas_api.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kleyton.gerenciador_de_pautas_api.models.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
	@Modifying
	@Query("UPDATE Pauta p SET p.inicioDeSessao = :inicioDeSessao, p.fimDeSessao = :fimDeSessao WHERE p.id = :id")
	void updateSessao(@Param("id") Long id, @Param("inicioDeSessao") LocalDateTime inicioDeSessao,
			@Param("fimDeSessao") LocalDateTime fimDeSessao);
}