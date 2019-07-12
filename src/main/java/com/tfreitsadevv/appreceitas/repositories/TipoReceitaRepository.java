package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.TipoReceita;

@Repository
public interface TipoReceitaRepository extends JpaRepository<TipoReceita, Integer>  {

}
