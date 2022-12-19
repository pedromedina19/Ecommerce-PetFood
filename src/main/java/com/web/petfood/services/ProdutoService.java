package com.web.petfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.petfood.models.Produto;
import com.web.petfood.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public void salvar(Produto produto) {
		produtoRepository.save(produto);
	}
	
	@Transactional
	public void alterar(Produto produto) {
		produtoRepository.save(produto);
	}
	
	@Transactional
	public void remover(Long codigo) {
		produtoRepository.deleteById(codigo);
	}
	
}
