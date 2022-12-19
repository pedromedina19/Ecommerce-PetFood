package com.web.petfood.repositories.queries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.web.petfood.models.Produto;
import com.web.petfood.models.filters.ProdutoFilter;

public interface ProdutoQueries {

	Page<Produto> pesquisar(ProdutoFilter filtro, Pageable pageable);
	
}
