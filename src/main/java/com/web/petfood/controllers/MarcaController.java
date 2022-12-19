package com.web.petfood.controllers;

import com.web.petfood.ajax.NotificacaoAlertify;
import com.web.petfood.ajax.TipoNotificacaoAlertify;
import com.web.petfood.models.Marca;
import com.web.petfood.models.Status;
import com.web.petfood.repositories.MarcaRepository;
import com.web.petfood.services.MarcaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/marcas")
public class MarcaController {
    private static final Logger logger = LoggerFactory.getLogger(MarcaController.class);

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/abrircadastrar")
    public String abrirCadastrar(Marca marca){
        return "marca/cadastrar";
    }

    private void colocarMarcasModelo(Model model) {
        List<Marca> marcas = marcaRepository.findByStatus(Status.ATIVO);
        model.addAttribute("marcas", marcas);
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Marca marca, BindingResult resultado, Model model){
        if (resultado.hasErrors()) {
            logger.info("A marca recebida para cadastrar não é válida.");
            logger.info("Erros encontrados:");
            for (FieldError erro : resultado.getFieldErrors()) {
                logger.info("{}", erro);
            }
            colocarMarcasModelo(model);
            return "marca/cadastrar";
        } else {
            marcaService.salvar(marca);
            return "redirect:/marcas/cadastrosucesso";
        }
    }

    @GetMapping("/cadastrosucesso")
	public String mostrarCadastroSucesso(Marca marca, Model model) {
        NotificacaoAlertify notificacao =
                new NotificacaoAlertify("Cadastro de marca efetuado com sucesso.",
                        TipoNotificacaoAlertify.SUCESSO);
        model.addAttribute("notificacao", notificacao);
		return "marca/cadastrar";
	}

    // @GetMapping("/abrirdropdown")
    // public String colocarItensNav(Categoria categoria, Marca marca){

    //     return
    // }

}
