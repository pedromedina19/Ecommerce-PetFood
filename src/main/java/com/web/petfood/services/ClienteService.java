package com.web.petfood.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.petfood.models.Cliente;
import com.web.petfood.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public void salvar(Cliente cliente){
        clienteRepository.save(cliente);
    }

    @Transactional
    public void alterar(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
