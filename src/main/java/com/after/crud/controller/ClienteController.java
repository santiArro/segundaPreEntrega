package com.after.crud.controller;


import com.after.crud.entity.Cliente;
import com.after.crud.repository.ClienteRepository;
import com.after.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

//agregammos las anotaciones
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
        try {
            Cliente clienteCreado = clienteService.guardar(cliente);
            return ResponseEntity.created(URI.create("")).body(clienteCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }


    }

    //Optener nuestros dtos por ID
    @GetMapping(value = "/[id", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Long id) {
        Optional<Cliente> posibleCliente = clienteService.buscaPorId(id);

        if (posibleCliente.isPresent()) {
            return ResponseEntity.of(posibleCliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(value = "/todos",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> todos(){
        return ResponseEntity.ok().body(clienteService.todos());
    }
    //creamos la anotacion de borrado y procedemos a poner la ruta donde se va a borarr
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPorId(@PathVariable(name = "id") Long id){
        clienteService.borraPorId(id);
        return ResponseEntity.ok().body("Cliente con ID =" + id + "ha sido borrado"  );
    }
}
