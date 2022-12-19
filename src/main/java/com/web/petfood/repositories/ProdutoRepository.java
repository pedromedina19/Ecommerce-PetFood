package com.web.petfood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.web.petfood.models.Produto;
import com.web.petfood.repositories.queries.ProdutoQueries;
import com.web.petfood.models.Status;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoQueries {
    List<Produto> findByStatus(Status status);
}
