package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer>  {

}
