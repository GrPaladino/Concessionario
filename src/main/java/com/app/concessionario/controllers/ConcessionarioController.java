package com.app.concessionario.controllers;

import com.app.concessionario.dto.ConcessionarioDTO;
import com.app.concessionario.services.ConcessonarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concessionari")
public class ConcessionarioController {

    @Autowired
    private ConcessonarioService concessonarioService;

    @GetMapping
    public ResponseEntity<?> getConcessionari() {
        if (concessonarioService.getConcessionariDTO() == null) {
            return new ResponseEntity<>("Nessun concessionario presente", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(concessonarioService.getConcessionariDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConcessionarioDTO(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(concessonarioService.getConcessionarioDTO(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addConcessionarioDTO(@RequestBody ConcessionarioDTO concessionarioDTO) {
        try {
            concessonarioService.addConcessionarioDTO(concessionarioDTO);
            return new ResponseEntity<>("Nuovo concessionario inserito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateConcessionarioDTO(@PathVariable Integer id, @RequestBody ConcessionarioDTO concessionarioDTO) {
        try {
            concessonarioService.updateConcessionarioDTO(id, concessionarioDTO);
            return new ResponseEntity<>("Concessionario modificato con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccessorio(@PathVariable Integer id) {
        try {
            concessonarioService.deleteConcessionario(id);
            return new ResponseEntity<>("Operazione effettuata con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//                                  ENDPOINT AVANZATI

    //    Lista auto per concessionario: Restituisce tutte le auto di un determinato concessionario.
    @GetMapping("/{id}/auto")
    public ResponseEntity<?> getAutoPerConcessionario(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(concessonarioService.getAutoPerConcessionario(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
