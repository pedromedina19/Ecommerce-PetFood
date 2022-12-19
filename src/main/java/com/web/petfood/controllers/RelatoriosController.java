package com.web.petfood.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.petfood.services.RelatorioService;

@Controller
@RequestMapping("/relatorios")
public class RelatoriosController {

	private static final Logger logger = LoggerFactory.getLogger(RelatoriosController.class);
	
	@Autowired
	private RelatorioService relatorioService;
	
	@GetMapping("/produtospormarcas")
	public ResponseEntity<byte[]> gerarRelatorioSimplesTodasPessoas() {
		logger.trace("Entrou em gerarRelatorioMarcasToProduto");
		logger.debug("Gerando relatório de produtos por marcas");
		
		byte[] relatorio = relatorioService.gerarRelatorioSimplesTodasPessoas();
		
		logger.debug("Relatório de produtos por marcas gerado");
		logger.debug("Retornando o relatório de produtos por marcas");
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProdutosPorMarcas.pdf")
				.body(relatorio);
	}
	
}
