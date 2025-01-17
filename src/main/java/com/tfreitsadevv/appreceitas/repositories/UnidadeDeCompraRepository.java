package com.tfreitsadevv.appreceitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitsadevv.appreceitas.domain.UnidadeDeCompra;

@Repository
public interface UnidadeDeCompraRepository extends JpaRepository<UnidadeDeCompra, Integer>  {

}
