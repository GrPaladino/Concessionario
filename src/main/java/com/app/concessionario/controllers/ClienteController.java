package com.app.concessionario.controllers;

import com.app.concessionario.dto.ClienteDTO;
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
    public List<ClienteDTO> getClientiDTO() {return clienteService.getClientiDTO();}

    @GetMapping("/cliente/{id}")
    public ClienteDTO getClienteDTO(@PathVariable Integer id) {return clienteService.getClienteDTO(id);}

    @PostMapping("/clienti")
    public void addClientiDTO(@RequestBody ClienteDTO clienteDTO) {clienteService.addClienteDTO(clienteDTO);}

    @PutMapping("/cliente/{id}")
    public void updateClienteDTO(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        clienteService.updateClienteDTO(id, clienteDTO);
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteCliente(@PathVariable Integer id) {clienteService.deleteCliente(id);}
}
