package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.IngredienteReceita;

@Repository
public interface IngredienteReceitaRepository extends JpaRepository<IngredienteReceita, Integer>  {

}
