package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.Embalagem;

@Repository
public interface EmbalagemRepository extends JpaRepository<Embalagem, Integer>  {

}
