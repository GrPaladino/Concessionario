package com.app.concessionario.controllers;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.services.AccessorioService;
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
@Tag(name = "accessori", description = "Accessori API")
@RequestMapping(value = "/api/accessori", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "404", description = "Accessorio non trovato"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
})
public class AccessorioController {

    @Autowired
    private AccessorioService accessorioService;

    @GetMapping
    @Operation(summary = "Cerca tutti gli accessori", description = "Recupera tutti gli accessori")
    @ApiResponse(responseCode = "200", description = "Accessori trovati")
    public ResponseEntity<?> getAccessori() throws Exception {
        try {
            return ResponseEntity.ok(accessorioService.getAccessoriDTO());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("{id}")
    @Operation(summary = "Cerca accessorio con ID", description = "Recupera l'accessorio con l'ID.")
    @ApiResponse(responseCode = "200", description = "Accessorio trovato",
            content = @Content(schema = @Schema(implementation = AccessorioDTO.class)))
    public ResponseEntity<?> getAccessorioDTO(@PathVariable Integer id) throws Exception {

        try {
            return ResponseEntity.ok(accessorioService.getAccessorioDto(id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @Operation(summary = "Crea accessorio", description = "Crea un nuovo accessorio")
    @ApiResponse(responseCode = "201", description = "Accessorio creato")
    public ResponseEntity<?> addAccessorioDTO(@RequestBody AccessorioDTO accessorioDTO) {
        try {
            accessorioService.addAccessorioDTO(accessorioDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(accessorioDTO);
        } catch (Exception e) {
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifica accessorio", description = "Modifica un accessorio")
    @ApiResponse(responseCode = "200", description = "Accessorio modificato")
    public ResponseEntity<?> updateAccessorio(@PathVariable Integer id, @RequestBody AccessorioDTO accessorioDTO) {
        try {
            accessorioService.updateAccessorioDTO(id, accessorioDTO);
            return ResponseEntity.ok().body(accessorioDTO);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Modifica accessorio", description = "Modifica un accessorio")
    @ApiResponse(responseCode = "200", description = "Accessorio modificato")
    public ResponseEntity<?> patchAccessorio(@PathVariable Integer id, @RequestBody AccessorioDTO patchAccessorioDTO) {
        try {
            accessorioService.patchAccessorioDTO(id, patchAccessorioDTO);
            return ResponseEntity.ok().body(accessorioService.getAccessorioDto(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancella accessorio", description = "Cancella un accessorio")
    @ApiResponse(responseCode = "200", description = "Accessorio cancellato")
    public ResponseEntity<?> deleteAccessorio(@PathVariable Integer id) {
        try {
            accessorioService.deleteAccessorio(id);
            return ResponseEntity.ok().body("Operazione effettuata con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
