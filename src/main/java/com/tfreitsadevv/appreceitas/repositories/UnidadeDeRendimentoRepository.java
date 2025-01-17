package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.UnidadeDeRendimento;

@Repository
public interface UnidadeDeRendimentoRepository extends JpaRepository<UnidadeDeRendimento, Integer>  {

}
