package com.web.petfood.controllers;


import com.web.petfood.ajax.NotificacaoAlertify;
import com.web.petfood.ajax.TipoNotificacaoAlertify;
import com.web.petfood.models.Categoria;
import com.web.petfood.models.Marca;
import com.web.petfood.models.Produto;
import com.web.petfood.models.Status;
import com.web.petfood.models.filters.ProdutoFilter;
import com.web.petfood.pagination.PageWrapper;
import com.web.petfood.repositories.MarcaRepository;
import com.web.petfood.repositories.ProdutoRepository;
import com.web.petfood.services.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	private static final Logger logger = LoggerFactory.getLogger(MarcaController.class);

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private MarcaRepository marcaRepository;

	// CADASTRO DE PRODUTOS
	@GetMapping("/abrircadastrar")
	public String abrirCadastrarProduto(Produto produto, Model model) {
		colocarCategoriaModelo(model);
		colocarMarcaModelo(model);
		return "produto/cadastrar";
	}

	private void colocarProdutosModelo(Model model) {
		List<Produto> produtos = produtoRepository.findByStatus(Status.ATIVO);
		model.addAttribute("produtos", produtos);
	}

	@PostMapping("/cadastrar")
	public String cadastrar(@Valid Produto produto, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			logger.info("O Produto recebido para cadastrar não é válido.");
			logger.info("Erros encontrados:");
			for (FieldError erro : resultado.getFieldErrors()) {
				logger.info("{}", erro);
			}
			colocarProdutosModelo(model);
			return "produto/cadastrar";
		} else {
			produtoService.salvar(produto);
			return "redirect:/produtos/cadastrosucesso";
		}
	}

	@GetMapping("/cadastrosucesso")
	public String mostrarCadastroSucesso(Produto produto, Model model) {
		NotificacaoAlertify notificacao =
				new NotificacaoAlertify("Cadastro de Produto efetuado com sucesso.",
						TipoNotificacaoAlertify.SUCESSO);
		model.addAttribute("notificacao", notificacao);
		return "produto/cadastrar";
	}

	// PESQUISAR PRODUTOS
	@GetMapping("/abrirpesquisar")
	public String abrirPesquisar(Model model) {
		colocarCategoriaModelo(model);
		colocarMarcaModelo(model);
		return "produto/pesquisar";
	}

	@GetMapping("/pesquisar")
	public String pesquisar(ProdutoFilter filtro, Model model,
			@PageableDefault(size = 8) @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
			HttpServletRequest request) {
		Page<Produto> page = produtoRepository.pesquisar(filtro, pageable);
		PageWrapper<Produto> pageWrapper = new PageWrapper<>(page, request);
		model.addAttribute("page", pageWrapper);
		System.out.println(page.getContent());
		/* System.out.println(pageWrapper.getConteudo()); */
		return "produto/mostrarprodutos";
	}
	@GetMapping("/pesquisarproduto")
	public String pesquisarProduto(ProdutoFilter filtro, Model model,
								   @PageableDefault(size = 8) @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
								   HttpServletRequest request) {
		Page<Produto> page = produtoRepository.pesquisar(filtro, pageable);
		PageWrapper<Produto> pageWrapper = new PageWrapper<>(page, request);
		model.addAttribute("page", pageWrapper);
		System.out.println(page.getContent());
		/* System.out.println(pageWrapper.getConteudo()); */
		return "produto/mostrarprodutosnormal";
	}
	// ALTERAR PRODUTOS
	@PostMapping("/abriralterar")
	public String abrirPesquisar(Produto produto, Model model) {
		colocarCategoriaModelo(model);
		colocarMarcaModelo(model);
		return "produto/alterar";
	}

	@PostMapping("/alterar")
	public String alterar(Produto produto) {
		produtoService.alterar(produto);
		return "redirect:/produtos/alterarsucesso";
	}

	@GetMapping("/alterarsucesso")
	public String mostrarAlterarSucesso(Model model) {
		model.addAttribute("mensagem", "Produto alterado com sucesso!");
		return "mostrarmensagem";
	}

	// REMOVER PRODUTOS
	@PostMapping("/confirmarremocao")
	public String confirmarRemocao(Produto produto) {
		return "produto/confirmarremocao";
	}

	@PostMapping("/remover")
	public String remover(Produto produto) {
		produto.setStatus(Status.INATIVO);
		produtoService.alterar(produto);
		return "redirect:/produtos/remocaosucesso";
	}
	
	@GetMapping("/remocaosucesso")
	public String mostrarRemocaoSucesso(Model model) {
		model.addAttribute("mensagem", "Produto removido com sucesso!");
		return "mostrarmensagem";
	}

	// //APLICANDO SESSÃO
	// @PostMapping("/abrirproduto")
	// public String abrirPaginaProduto(Produto produto, Model model, HttpSession sessao){
	// 	sessao.setAttribute("produto", produto);
	// 	return "produto/paginaproduto";
	// }
	//ABRIR PAGINA DO PRODUTO
	@PostMapping("/abrirproduto")
	public String abrirPaginaProduto(Produto produto){
		return "produto/paginaproduto";
	}

	// COLOCAR CATEGORIAS NO MODELO
	public void colocarCategoriaModelo(Model model) {
		List<Categoria> categoria = Arrays.asList(Categoria.values());
		model.addAttribute("categoria", categoria);
	}

	public void colocarMarcaModelo(Model model){
		List<Marca> marca = marcaRepository.findByStatus(Status.ATIVO);
		model.addAttribute("marca", marca);
	}

}
