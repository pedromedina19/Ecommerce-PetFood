package com.web.petfood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.petfood.models.Marca;
import com.web.petfood.models.Status;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
    List<Marca> findByStatus(Status status);
}