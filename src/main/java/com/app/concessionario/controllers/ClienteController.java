package com.app.concessionario.controllers;

import com.app.concessionario.dto.ClienteDTO;
import com.app.concessionario.entity.Cliente;
import com.app.concessionario.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> getClientiDTO() {
        if (clienteService.getClientiDTO() == null) {
            return new ResponseEntity<>("Nessun cliente presente", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteService.getClientiDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteDTO(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(clienteService.getClienteDTO(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addClientiDTO(@RequestBody ClienteDTO clienteDTO) {
        try {
            clienteService.addClienteDTO(clienteDTO);
            return new ResponseEntity<>("Nuova auto inserita",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClienteDTO(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        try {
            clienteService.updateClienteDTO(id, clienteDTO);
            return new ResponseEntity<>("Cliente modificato con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Integer id) {
        try {
            clienteService.deleteCliente(id);
            return new ResponseEntity<>("Operazione effettuata con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
