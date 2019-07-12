package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.EmbalagemReceita;

@Repository
public interface EmbalagemReceitaRepository extends JpaRepository<EmbalagemReceita, Integer>  {

}
