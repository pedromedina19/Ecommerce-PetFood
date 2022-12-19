package com.web.petfood.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.petfood.models.Endereco;
import com.web.petfood.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public void salvar(Endereco endereco){
        enderecoRepository.save(endereco);
    }

    @Transactional
    public void alterar(Endereco endereco){
        enderecoRepository.save(endereco);
    }

}
