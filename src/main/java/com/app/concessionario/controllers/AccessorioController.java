package com.app.concessionario.controllers;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.repositories.AccessorioRepository;
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

import java.util.List;

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
//        if (accessorioService.getAccessoriDTO() == null) {
//            return new ResponseEntity<>("Nessun accessorio presente", HttpStatus.NOT_FOUND);
//        }
//        return ResponseEntity.ok(accessorioService.getAccessoriDTO());
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


//        try {
//            return ResponseEntity.ok(accessorioService.getAccessorioDto(id));
//        } catch (Exception e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getAccessorio(@PathVariable Integer id) {
//        try {
//            return new ResponseEntity<>(accessorioService.getAccessorioDto(id), HttpStatus.OK);
//        }
//        catch(Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping
    public ResponseEntity<?> addAccessorioDTO(@RequestBody AccessorioDTO accessorioDTO) {
        try {
            accessorioService.addAccessorioDTO(accessorioDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(accessorioDTO);
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccessorio(@PathVariable Integer id, @RequestBody AccessorioDTO accessorioDTO) {
        try {
            accessorioService.updateAccessorioDTO(id, accessorioDTO);
            return new ResponseEntity<>("Accessorio modificato con successo", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchAccessorio(@PathVariable Integer id, @RequestBody AccessorioDTO accessorioDTO) {
        try {
            accessorioService.patchAccessorioDTO(id, accessorioDTO);
            return new ResponseEntity<>("Accessorio modificato con successo", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccessorio(@PathVariable Integer id) {
        try {
            accessorioService.deleteAccessorio(id);
            return  new ResponseEntity<>("Operazione effettuata con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
