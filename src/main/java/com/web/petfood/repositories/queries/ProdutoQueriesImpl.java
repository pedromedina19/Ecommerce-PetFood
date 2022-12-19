package com.web.petfood.repositories.queries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.web.petfood.models.Categoria;
import com.web.petfood.models.Marca;
import com.web.petfood.models.Produto;
import com.web.petfood.models.Status;
import com.web.petfood.models.filters.ProdutoFilter;
import com.web.petfood.pagination.PaginacaoUtil;

public class ProdutoQueriesImpl implements ProdutoQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Produto> pesquisar(ProdutoFilter filtro, Pageable pageable) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
		Root<Produto> p = criteriaQuery.from(Produto.class);
		p.fetch("marca",JoinType.INNER);
		TypedQuery<Produto> typedQuery;
		List<Predicate> predicateList = new ArrayList<>();

		if(filtro.getId() != null) {
			predicateList.add(builder.equal(p.<Long>get("id"), filtro.getId()));
		}

		if(filtro.getCodigomarca() != null){
			predicateList.add(builder.equal(p.<Marca>get("marca").<Long>get("id"), filtro.getCodigomarca()));
		}

		if(filtro.getMenorPreco() != null){
			predicateList.add(builder.lessThanOrEqualTo(p.<Float>get("valorVenda"),filtro.getMenorPreco()));
		}

		if(filtro.getMaiorPreco() != null){
			predicateList.add(builder.greaterThanOrEqualTo(p.<Float>get("valorVenda"),filtro.getMaiorPreco()));
		}

		if (StringUtils.hasText(filtro.getNome())) {
			predicateList.add(builder.like(
					builder.lower(p.<String>get("nome")),
					"%" + filtro.getNome().toLowerCase() + "%"));
		}

		if (StringUtils.hasText(filtro.getDescricao())) {
			predicateList.add(builder.like(
					builder.lower(p.<String>get("descricao")),
					"%" + filtro.getDescricao().toLowerCase() + "%"));
		}

		if(filtro.getCategoria() != null){
			predicateList.add(builder.equal(p.<Categoria>get("categoria"), filtro.getCategoria()));
		}

		predicateList.add(builder.equal(p.<Status>get("status"), Status.ATIVO));

		Predicate[] predArray = new Predicate[predicateList.size()];
		predicateList.toArray(predArray);

		criteriaQuery.select(p).where(predArray);

		PaginacaoUtil.prepararOrdem(p, criteriaQuery, builder, pageable);

		typedQuery = manager.createQuery(criteriaQuery);

		PaginacaoUtil.prepararIntervalo(typedQuery, pageable);

		List<Produto> produtos = typedQuery.getResultList();

		long totalProducts = PaginacaoUtil.getTotalRegistros(p, predArray, builder, manager);
		Page<Produto> page = new PageImpl<>(produtos, pageable, totalProducts);

		return page;
	}

}