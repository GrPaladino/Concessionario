package com.app.concessionario.controllers;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.dto.ConcessionarioDTO;
import com.app.concessionario.services.ConcessonarioService;
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

import java.util.List;

@RestController@Tag(name = "concessionari", description = "Concessionari API")
@RequestMapping(value = "/api/concessionari", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Concessionario non trovato"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
})
public class ConcessionarioController {

    @Autowired
    private ConcessonarioService concessonarioService;

    @GetMapping
    @Operation(summary = "Cerca tutti i concessionari", description = "Recupera tutti i concessionari")
    @ApiResponse(responseCode = "200", description = "Concessionari trovati")
    public ResponseEntity<?> getConcessionari() {
        try {
            return ResponseEntity.ok(concessonarioService.getConcessionariDTO());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Cerca concessionario con ID", description = "Recupera il concessionario con l'ID.")
    @ApiResponse(responseCode = "200", description = "Concessionario trovato",
            content = @Content(schema = @Schema(implementation = AccessorioDTO.class)))
    public ResponseEntity<?> getConcessionarioDTO(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(concessonarioService.getConcessionarioDTO(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @Operation(summary = "Crea concessionario", description = "Crea un nuovo concessionario")
    @ApiResponse(responseCode = "201", description = "Concessionario creato")
    public ResponseEntity<?> addConcessionarioDTO(@RequestBody ConcessionarioDTO concessionarioDTO) {
        try {
            concessonarioService.addConcessionarioDTO(concessionarioDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(concessionarioDTO);
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifica concessionario", description = "Modifica un concessionario")
    @ApiResponse(responseCode = "200", description = "Concessionario modificato")
    public ResponseEntity<?> updateConcessionarioDTO(@PathVariable Integer id, @RequestBody ConcessionarioDTO concessionarioDTO) {
        try {
            concessonarioService.updateConcessionarioDTO(id, concessionarioDTO);
            return ResponseEntity.ok().body(concessionarioDTO);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Modifica concessionario", description = "Modifica un concessionario")
    @ApiResponse(responseCode = "200", description = "Concessionario modificato")
    public ResponseEntity<?> patchConcessionarioDTO(@PathVariable Integer id, @RequestBody ConcessionarioDTO patchConcessionarioDTO) {
        try {
            concessonarioService.patchConcessionarioDTO(id, patchConcessionarioDTO);
            return ResponseEntity.ok().body(concessonarioService.getConcessionarioDTO(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancella concessionario", description = "Cancella un concessionario")
    @ApiResponse(responseCode = "200", description = "Concessionario cancellato")
    public ResponseEntity<?> deleteAccessorio(@PathVariable Integer id) {
        try {
            concessonarioService.deleteConcessionario(id);
            return ResponseEntity.ok().body("Operazione effettuata con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

//                                  ENDPOINT AVANZATI

    //    Lista auto per concessionario: Restituisce tutte le auto di un determinato concessionario.
    @GetMapping("/{id}/auto")
    @Operation(summary = "Cerca le auto di un concessionario", description = "Recupera le auto con il concessionario ID.")
    @ApiResponse(responseCode = "200", description = "Auto trovate")
    public ResponseEntity<?> getAutoPerConcessionario(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok().body(concessonarioService.getAutoPerConcessionario(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
