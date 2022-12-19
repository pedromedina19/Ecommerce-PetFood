package com.web.petfood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.petfood.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
