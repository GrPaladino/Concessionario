package com.app.concessionario.controllers;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.entity.Accessorio;
import com.app.concessionario.services.AccessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccessorioController {

    @Autowired
    private AccessorioService optionalService;

    @GetMapping("/accessori")
    public List<Accessorio> getOptionals() {return optionalService.getOptionals();}

    @GetMapping("/accessorio/{id}")
    public AccessorioDTO getAccessorioDTO(@PathVariable Integer id) {
        return optionalService.getAccessorioDto(id);
    }

    @PostMapping("/accessori")
    public void addOptional(@RequestBody AccessorioDTO accessorioDTO) {optionalService.addAccessorioDTO(accessorioDTO);}

    @PutMapping("/accessorio/{id}")
    public void updateOptional(@PathVariable Integer id, @RequestBody Accessorio accessorio) {
        optionalService.updateOptional(id, accessorio);
    }

    @DeleteMapping("/accessorio/{id}")
    public void deleteOptional(@PathVariable Integer id) {optionalService.deleteOptional(id);}

}
