package com.app.concessionario.controllers;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.dto.MotoreDTO;
import com.app.concessionario.services.MotoreService;
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
@Tag(name = "motori", description = "Motori API")
@RequestMapping(value = "/api/motori", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Motore non trovato"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
})
public class MotoreController {

    @Autowired
    private MotoreService motoreService;

    @GetMapping
    @Operation(summary = "Cerca tutti gli motori", description = "Recupera tutti i motori")
    @ApiResponse(responseCode = "200", description = "Motori trovati")
    public ResponseEntity<?> getMotoriDTO() {
        try {
            return ResponseEntity.ok(motoreService.getMotoriDTO());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Cerca motore con ID", description = "Recupera il motore con l'ID.")
    @ApiResponse(responseCode = "200", description = "Motore trovato",
            content = @Content(schema = @Schema(implementation = AccessorioDTO.class)))
    public ResponseEntity<?> getMotoreDTO(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(motoreService.getMotoreDTO(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @Operation(summary = "Crea motore", description = "Crea un nuovo motore")
    @ApiResponse(responseCode = "201", description = "Motore creato")
    public ResponseEntity<?> addMotoreDTO(@RequestBody MotoreDTO motoreDTO) {
        try {
            motoreService.addMotoreDTO(motoreDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(motoreDTO);
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifica motore", description = "Modifica un motore")
    @ApiResponse(responseCode = "200", description = "Motore modificato")
    public ResponseEntity<?> updateMotoreDTO(@PathVariable Integer id, @RequestBody MotoreDTO motoreDTO) {
        try {
            motoreService.updateMotoreDTO(id, motoreDTO);
            return ResponseEntity.ok().body(motoreDTO);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Modifica motore", description = "Modifica un motore")
    @ApiResponse(responseCode = "200", description = "Motore modificato")
    public ResponseEntity<?> patchMotoreDTO(@PathVariable Integer id, @RequestBody MotoreDTO patchMotoreDTO) {
        try {
            motoreService.patchMotoreDTO(id, patchMotoreDTO);
            return ResponseEntity.ok().body(motoreService.getMotoreDTO(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancella motore", description = "Cancella un motore")
    @ApiResponse(responseCode = "200", description = "Motore cancellato")
    public ResponseEntity<?> deleteMotore(@PathVariable Integer id) {
        try {
            motoreService.deleteMotore(id);
            return ResponseEntity.ok().body("Operazione effettuata con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
