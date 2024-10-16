package com.app.concessionario.controllers;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.services.AccessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccessorioController {

    @Autowired
    private AccessorioService accessorioService;

    @GetMapping("/accessori")
    public ResponseEntity<?> getAccessori() {
        if (accessorioService.getAccessoriDTO() == null) {
            return new ResponseEntity<>("Nessun accessorio presente", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accessorioService.getAccessoriDTO(), HttpStatus.OK);
    }

    @GetMapping("/accessorio/{id}")
    public ResponseEntity<?> getAccessorio(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(accessorioService.getAccessorioDto(id), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/accessori")
    public ResponseEntity<?> addAccessorioDTO(@RequestBody AccessorioDTO accessorioDTO) {
        try {
            accessorioService.addAccessorioDTO(accessorioDTO);
            return new ResponseEntity<>("Nuovo accessorio inserito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/accessorio/{id}")
    public ResponseEntity<?> updateAccessorio(@PathVariable Integer id, @RequestBody AccessorioDTO accessorioDTO) {
        try {
            accessorioService.updateAccessorioDTO(id, accessorioDTO);
            return new ResponseEntity<>("Accessorio modificato con successo", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/accessorio/{id}")
    public ResponseEntity<?> deleteAccessorio(@PathVariable Integer id) {
        try {
            accessorioService.deleteAccessorio(id);
            return  new ResponseEntity<>("Operazione effettuata con successo", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
