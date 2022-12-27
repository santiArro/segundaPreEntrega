package com.after.crud.service;

import com.after.crud.entity.Cliente;
import com.after.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    //no necesitamos unicializar la Variable
    @Autowired
    private ClienteRepository clienteRepository;
    //esta fuencion es para crear un nuevo registro si el cliente no existe y si exite actauliza el registro


    public Cliente guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public Optional<Cliente> buscaPorId(Long id){
        return clienteRepository.findById(id);
    }
    public List<Cliente> todos(){
        return clienteRepository.findAll();
    }
    public void borraPorId(Long id){
        clienteRepository.deleteById(id);
    }
}
