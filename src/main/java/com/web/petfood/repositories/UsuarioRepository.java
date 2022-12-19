package com.web.petfood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.petfood.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByNomeUsuarioIgnoreCase(String nomeUsuario);
	
}