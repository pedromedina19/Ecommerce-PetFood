package com.web.petfood.repositories;

import com.web.petfood.models.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("from Cliente where email=?1")
	public List<Cliente> buscarClienteEmail(String email);
}
