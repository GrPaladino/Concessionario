package com.app.concessionario.controllers;

import com.app.concessionario.dto.MotoreDTO;
import com.app.concessionario.entity.Motore;
import com.app.concessionario.services.MotoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motori")
public class MotoreController {

    @Autowired
    private MotoreService motoreService;

    @GetMapping
    public ResponseEntity<?> getMotoriDTO() {
        if (motoreService.getMotoriDTO() == null) {
            return new ResponseEntity<>("Nessun motore presente", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(motoreService.getMotoriDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMotoreDTO(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(motoreService.getMotoreDTO(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addMotoreDTO(@RequestBody MotoreDTO motoreDTO) {
        try {
            motoreService.addMotoreDTO(motoreDTO);
            return new ResponseEntity<>("Nuovo motore inserito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMotoreDTO(@PathVariable Integer id, @RequestBody MotoreDTO motoreDTO) {
        try {
            motoreService.updateMotoreDTO(id, motoreDTO);
            return new ResponseEntity<>("Motore modificato con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchMotoreDTO(@PathVariable Integer id, @RequestBody MotoreDTO patchMotoreDTO) {
        try {
            motoreService.patchMotoreDTO(id, patchMotoreDTO);
            return new ResponseEntity<>("Motore modificato con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMotore(@PathVariable Integer id) {
        try {
            motoreService.deleteMotore(id);
            return  new ResponseEntity<>("Operazione effettuata con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
