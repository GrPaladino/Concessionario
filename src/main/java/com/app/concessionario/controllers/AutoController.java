package com.app.concessionario.controllers;

import com.app.concessionario.dto.AutoDTO;
import com.app.concessionario.services.AutoService;
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
@Tag(name = "auto", description = "Auto API")
@RequestMapping(value = "/api/auto", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Auto non trovato"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
})
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping
    @Operation(summary = "Cerca tutte le auto", description = "Recupera tutte le auto")
    @ApiResponse(responseCode = "200", description = "Auto trovate")
    public ResponseEntity<?> getAutosDTO() {
        try {
            return ResponseEntity.ok().body(autoService.getAutosDTO());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Cerca auto", description = "Recupera una auto")
    @ApiResponse(responseCode = "200", description = "Auto trovata",
            content = @Content(schema = @Schema(implementation = AutoDTO.class)))
    public ResponseEntity<?> getAutoDTO(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(autoService.getAutoDTO(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @Operation(summary = "Crea auto", description = "Crea un nuova auto")
    @ApiResponse(responseCode = "201", description = "Auto creata")
    public ResponseEntity<?> addAutoDTO(@RequestBody AutoDTO autoDTO) {
        try {
            autoService.addAutoDTO(autoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(autoDTO);
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifica auto", description = "Modifica un'auto")
    @ApiResponse(responseCode = "200", description = "Auto modificata")
    public ResponseEntity<?> updateAutoDTO(@PathVariable Integer id, @RequestBody AutoDTO autoDTO) {
        try {
            autoService.updateAutoDTO(id, autoDTO);
            return ResponseEntity.ok().body(autoDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Modifica auto", description = "Modifica un'auto")
    @ApiResponse(responseCode = "200", description = "Auto modificata")
    public ResponseEntity<?> patchAuto(@PathVariable Integer id, @RequestBody AutoDTO patchAutoDTO) {
        try {
            autoService.patchAutoDTO(id, patchAutoDTO);
            return ResponseEntity.ok().body(autoService.getAutoDTO(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancella auto", description = "Cancella un'auto")
    @ApiResponse(responseCode = "200", description = "Auto cancellata")
    public ResponseEntity<?> deleteAuto(@PathVariable Integer id) {
        try {
            autoService.deleteAuto(id);
            return ResponseEntity.ok().body("Operazione effettuata con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

//                              ENDPOINT AVANZATI

    //    endpoint per assegnare un cliente ad un auto venduta
    @PutMapping("/{autoId}/cliente/{clienteId}")
    @Operation(summary = "Auto venduta", description = "Assegna un auto ad un cliente")
    @ApiResponse(responseCode = "200", description = "Auto venduta")
    public ResponseEntity<?> sellAuto(@PathVariable Integer autoId, @PathVariable Integer clienteId) {
        try {
            autoService.sellAuto(autoId, clienteId);
            return ResponseEntity.ok().body("Operazione effettuata con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
