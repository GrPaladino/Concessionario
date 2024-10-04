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
    public List<Accessorio> getAccessori() {return optionalService.getAccessori();}

    @GetMapping("/accessorio/{id}")
    public AccessorioDTO getAccessorioDTO(@PathVariable Integer id) {
        return optionalService.getAccessorioDto(id);
    }

    @PostMapping("/accessori")
    public void addAccessorioDTO(@RequestBody AccessorioDTO accessorioDTO) {optionalService.addAccessorioDTO(accessorioDTO);}

    @PutMapping("/accessorio/{id}")
    public void updateAccessorio(@PathVariable Integer id, @RequestBody Accessorio accessorio) {
        optionalService.updateAccessorio(id, accessorio);
    }

    @DeleteMapping("/accessorio/{id}")
    public void deleteAccessorio(@PathVariable Integer id) {optionalService.deleteAccessorio(id);}

}
