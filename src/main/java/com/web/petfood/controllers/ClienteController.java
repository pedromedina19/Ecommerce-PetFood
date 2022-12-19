package com.web.petfood.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.petfood.models.Cliente;
import com.web.petfood.models.Endereco;
import com.web.petfood.models.UF;
import com.web.petfood.repositories.ClienteRepository;
import com.web.petfood.services.ClienteService;
import com.web.petfood.services.EnderecoService;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping("/abrircadastrar")
	public String abrirCadastrar(Cliente cliente, Endereco endereco,Model model) {
		colocarUfModelo(model);
		return "cliente/cadastrar";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Cliente cliente, Endereco endereco,Model model){
		clienteService.salvar(cliente);
		//enderecoService.salvar(endereco);
		return "redirect:/clientes/cadastrosucesso";
	}

	@GetMapping("/cadastrosucesso")
	public String mostrarCadastroSucesso(Model model) {
		model.addAttribute("mensagem",
				"Cadastro de cliente efetuado com sucesso.");
		return "mostrarmensagem";
	}


	@GetMapping("/entrar")
	public String abrirEntrar(Cliente cliente) {
		clienteService.salvar(cliente);
		return "cliente/login";
	}

	public void colocarUfModelo(Model model) {
		List<UF> uf = Arrays.asList(UF.values());
		model.addAttribute("uf", uf); 
	}
}
