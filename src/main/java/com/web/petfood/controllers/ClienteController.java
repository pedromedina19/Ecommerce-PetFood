package com.web.petfood.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.web.petfood.models.Cliente;
import com.web.petfood.models.Endereco;
import com.web.petfood.models.Papel;
import com.web.petfood.models.UF;
import com.web.petfood.models.Usuario;
import com.web.petfood.repositories.ClienteRepository;
import com.web.petfood.repositories.PapelRepository;
import com.web.petfood.services.CadastroUsuarioService;
import com.web.petfood.services.ClienteService;
import com.web.petfood.services.EnderecoService;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;

	@Autowired
	private PapelRepository papelRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/abrircadastrar")
	public String abrirCadastrar(Usuario usuario, Endereco endereco,Model model) {
		colocarUfModelo(model);
		return "cliente/cadastrar";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(@Valid Usuario usuario, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			logger.info("O usuario recebido para cadastrar não é válido.");
			logger.info("Erros encontrados:");
			for (FieldError erro : resultado.getFieldErrors()) {
				logger.info("{}", erro);
			}
			List<Papel> papeis = papelRepository.findAll();
			model.addAttribute("todosPapeis", papeis);
			return "usuario/cadastrar";
		} else {
			List<Long> ids = Arrays.asList(3L,null,null);
			usuario.setPapeis(papelRepository.findAllById(ids));
			usuario.setAtivo(true);
			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			cadastroUsuarioService.salvar(usuario);
			return "redirect:/clientes/cadastrosucesso";
		}
	}

	@GetMapping("/cadastrosucesso")
	public String mostrarCadastroSucesso(Model model) {
		model.addAttribute("mensagem",
				"Cadastro de Cliente efetuado com sucesso.");
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
