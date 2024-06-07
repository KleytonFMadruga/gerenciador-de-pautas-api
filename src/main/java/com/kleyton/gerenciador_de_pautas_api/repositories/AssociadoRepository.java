package com.kleyton.gerenciador_de_pautas_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kleyton.gerenciador_de_pautas_api.models.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Integer> {

}
