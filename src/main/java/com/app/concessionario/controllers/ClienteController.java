package com.app.concessionario.controllers;

import com.app.concessionario.dto.ClienteDTO;
import com.app.concessionario.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "clienti", description = "Clienti API")
@RequestMapping(value = "/api/clienti", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Cliente non trovato"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
})
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Cerca tutti i clienti", description = "Recupera tutti i clienti")
    @ApiResponse(responseCode = "200", description = "Clienti trovati")
    public ResponseEntity<?> getClientiDTO() {
        try {
            return ResponseEntity.ok(clienteService.getClientiDTO());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Cerca cliente con ID", description = "Recupera il cliente con l'ID.")
    @ApiResponse(responseCode = "200", description = "Cliente trovato",
            content = @Content(schema = @Schema(implementation = ClienteDTO.class)))
    public ResponseEntity<?> getClienteDTO(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(clienteService.getClienteDTO(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @Operation(summary = "Crea cliente", description = "Crea un nuovo cliente")
    @ApiResponse(responseCode = "201", description = "Cliente creato")
    public ResponseEntity<?> addClientiDTO(@RequestBody ClienteDTO clienteDTO) {
        try {
            clienteService.addClienteDTO(clienteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifica cliente", description = "Modifica un cliente")
    @ApiResponse(responseCode = "200", description = "Cliente modificato")
    public ResponseEntity<?> updateClienteDTO(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        try {
            clienteService.updateClienteDTO(id, clienteDTO);
            return ResponseEntity.ok().body(clienteDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Modifica cliente", description = "Modifica un cliente")
    @ApiResponse(responseCode = "200", description = "Cliente modificato")
    public ResponseEntity<?> patchClienteDTO(@PathVariable Integer id, @RequestBody ClienteDTO patchClienteDTO) {
        try {
            clienteService.patchClienteDTO(id, patchClienteDTO);
            return ResponseEntity.ok().body(clienteService.getClienteDTO(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancella cliente", description = "Cancella un cliente")
    @ApiResponse(responseCode = "200", description = "Cliente cancellato")
    public ResponseEntity<?> deleteCliente(@PathVariable Integer id) {
        try {
            clienteService.deleteCliente(id);
            return ResponseEntity.ok().body("Operazione effettuata con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
