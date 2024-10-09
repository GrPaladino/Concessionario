package com.app.concessionario.controllers;

import com.app.concessionario.dto.AutoDTO;
import com.app.concessionario.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping("/auto")
    public List<AutoDTO> getAutosDTO() {return autoService.getAutosDTO();}

    @GetMapping("/auto/{id}")
    public AutoDTO getAutoDTO(@PathVariable Integer id) {return autoService.getAutoDTO(id);}

    @PostMapping("/auto")
    public void addAutoDTO(@RequestBody AutoDTO autoDTO) {autoService.addAutoDTO(autoDTO);}

    @PutMapping("/auto/{id}")
    public void updateAutoDTO(@PathVariable Integer id, @RequestBody AutoDTO autoDTO) {
        autoService.updateAutoDTO(id, autoDTO);
    }

    @DeleteMapping("/auto/{id}")
    public void deleteAuto(@PathVariable Integer id) {autoService.deleteAuto(id);}

//                              ENDPOINT AVANZATI

//    endpoint per assegnare un cliente ad un auto venduta
    @PutMapping("/auto/{autoId}/cliente/{clienteId}")
    public void sellAuto(@PathVariable Integer autoId, @PathVariable Integer clienteId) throws Exception {
        autoService.sellAuto(autoId, clienteId);
    }
}
