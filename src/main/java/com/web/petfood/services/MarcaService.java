package com.web.petfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.petfood.models.Marca;
import com.web.petfood.repositories.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Transactional
	public void salvar(Marca marca) {
		marcaRepository.save(marca);
	}
	
	@Transactional
	public void alterar(Marca marca) {
		marcaRepository.save(marca);
	}
	
	@Transactional
	public void remover(Long codigo) {
		marcaRepository.deleteById(codigo);
	}
	
}
