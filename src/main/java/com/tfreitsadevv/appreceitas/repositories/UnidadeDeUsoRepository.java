package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.UnidadeDeUso;

@Repository
public interface UnidadeDeUsoRepository extends JpaRepository<UnidadeDeUso, Integer>  {

}
