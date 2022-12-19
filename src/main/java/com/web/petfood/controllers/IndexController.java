package com.web.petfood.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.petfood.models.Produto;
import com.web.petfood.models.filters.ProdutoFilter;
import com.web.petfood.pagination.PageWrapper;
import com.web.petfood.repositories.ProdutoRepository;

@Controller
public class IndexController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping(value = {"/", "/index.html"} )
	public String index(ProdutoFilter filtro, Model model, @PageableDefault(size=8)
		@SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
		HttpServletRequest request) {
			Page<Produto> page = produtoRepository.pesquisar(filtro, pageable);
			PageWrapper<Produto> pageWrapper = new PageWrapper<>(page, request);
			model.addAttribute("page", pageWrapper);
			// System.out.println(page.getContent());
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}