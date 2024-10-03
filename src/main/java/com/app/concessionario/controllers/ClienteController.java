package com.app.concessionario.controllers;

import com.app.concessionario.entity.Cliente;
import com.app.concessionario.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clienti")
    public List<Cliente> getConcessionari() {return clienteService.getClienti();}

    @GetMapping("/cliente/{id}")
    public Cliente getCliente(@PathVariable Integer id) {return clienteService.getCliente(id);}

    @PostMapping("/clienti")
    public void addClienti(@RequestBody Cliente cliente) {clienteService.addCliente(cliente);}

    @PutMapping("/cliente/{id}")
    public void updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteCliente(@PathVariable Integer id) {clienteService.deleteCliente(id);}
}
