package main.java.com.app.concessionario.controllers;

import main.java.com.app.concessionario.entity.Concessionario;
import main.java.com.app.concessionario.services.ConcessonarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConcessionarioController {

    @Autowired
    private ConcessonarioService concessonarioService;

    @GetMapping("/concessionari")
    public List<Concessionario> getConcessionari() {return concessonarioService.getConcessionari();}

    @GetMapping("/concessionario/{id}")
    public Concessionario getConcessionario(@PathVariable Integer id) {return concessonarioService.getConcessionario(id);}

    @PostMapping("/concessionari")
    public void addConcessionario(@RequestBody Concessionario concessionario) {concessonarioService.addConcessionario(concessionario);}

    @PutMapping("/concessionario/{id}")
    public void updateConcessionario(@PathVariable Integer id, @RequestBody Concessionario concessionario) {
        concessonarioService.updateConcessionario(id, concessionario);
    }

    @DeleteMapping("/concessionario/{id}")
    public void deleteConcessionario(@PathVariable Integer id) {concessonarioService.deleteConcessionario(id);}
}
