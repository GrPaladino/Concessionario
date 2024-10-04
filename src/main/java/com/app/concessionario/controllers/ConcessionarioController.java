package com.app.concessionario.controllers;

import com.app.concessionario.dto.ConcessionarioDTO;
import com.app.concessionario.services.ConcessonarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConcessionarioController {

    @Autowired
    private ConcessonarioService concessonarioService;

    @GetMapping("/concessionari")
    public List<ConcessionarioDTO> getConcessionariDTO() {return concessonarioService.getConcessionariDTO();}

    @GetMapping("/concessionario/{id}")
    public ConcessionarioDTO getConcessionarioDTO(@PathVariable Integer id) {return concessonarioService.getConcessionarioDTO(id);}

    @PostMapping("/concessionari")
    public void addConcessionarioDTO(@RequestBody ConcessionarioDTO concessionarioDTO) {concessonarioService.addConcessionarioDTO(concessionarioDTO);}

    @PutMapping("/concessionario/{id}")
    public void updateConcessionarioDTO(@PathVariable Integer id, @RequestBody ConcessionarioDTO concessionarioDTO) {
        concessonarioService.updateConcessionarioDTO(id, concessionarioDTO);
    }

    @DeleteMapping("/concessionario/{id}")
    public void deleteConcessionario(@PathVariable Integer id) {concessonarioService.deleteConcessionario(id);}
}
