package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.Conversao;

@Repository
public interface ConversaoRepository extends JpaRepository<Conversao, Integer>  {

}
