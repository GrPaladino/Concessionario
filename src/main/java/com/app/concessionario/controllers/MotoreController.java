package com.app.concessionario.controllers;

import com.app.concessionario.dto.MotoreDTO;
import com.app.concessionario.entity.Motore;
import com.app.concessionario.services.MotoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotoreController {

    @Autowired
    private MotoreService motoreService;

    @GetMapping("/motori")
    public List<MotoreDTO> getMotoriDTO() {return motoreService.getMotoriDTO();}

    @GetMapping("/motore/{id}")
    public MotoreDTO getMotoreDTO(@PathVariable Integer id) {return motoreService.getMotoreDTO(id);}

    @PostMapping("/motori")
    public void addMotoreDTO(@RequestBody MotoreDTO motoreDTO) {motoreService.addMotoreDTO(motoreDTO);}

    @PutMapping("/motore/{id}")
    public void updateMotoreDTO(@PathVariable Integer id, @RequestBody MotoreDTO motoreDTO) {
        motoreService.updateMotoreDTO(id, motoreDTO);
    }

    @DeleteMapping("/motore/{id}")
    public void deleteMotore(@PathVariable Integer id) {motoreService.deleteMotore(id);}
}
