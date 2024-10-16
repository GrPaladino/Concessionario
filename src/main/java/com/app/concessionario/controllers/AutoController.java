package com.app.concessionario.controllers;

import com.app.concessionario.dto.AutoDTO;
import com.app.concessionario.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auto")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping
    public ResponseEntity<?> getAutosDTO() {
        if (autoService.getAutosDTO() == null)
            return new ResponseEntity<>("Nessuna auto presente", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(autoService.getAutosDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAutoDTO(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(autoService.getAutoDTO(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addAutoDTO(@RequestBody AutoDTO autoDTO) {
        try {
            autoService.addAutoDTO(autoDTO);
            return new ResponseEntity<>("Nuova auto inserita", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAutoDTO(@PathVariable Integer id, @RequestBody AutoDTO autoDTO) {
        try {
            autoService.updateAutoDTO(id, autoDTO);
            return new ResponseEntity<>("Operazione effettuata con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchAuto(@PathVariable Integer id, @RequestBody AutoDTO patchAutoDTO) {
        try {
            autoService.patchAutoDTO(id, patchAutoDTO);
            return new ResponseEntity<>("Operazione effettuata con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuto(@PathVariable Integer id) {
        try {
            autoService.deleteAuto(id);
            return new ResponseEntity<>("Operazione effettuata con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//                              ENDPOINT AVANZATI

    //    endpoint per assegnare un cliente ad un auto venduta
    @PutMapping("/{autoId}/cliente/{clienteId}")
    public ResponseEntity<?> sellAuto(@PathVariable Integer autoId, @PathVariable Integer clienteId) {
        try {
            autoService.sellAuto(autoId, clienteId);
            return new ResponseEntity<>("Operazione effettuata con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
