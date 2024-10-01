package main.java.com.app.concessionario.controllers;

import main.java.com.app.concessionario.entity.Motore;
import main.java.com.app.concessionario.services.MotoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotoreController {

    @Autowired
    private MotoreService motoreService;

    @GetMapping("/motori")
    public List<Motore> getMotori() {return motoreService.getMotori();}

    @GetMapping("/motore/{id}")
    public Motore getMotore(@PathVariable Integer id) {return motoreService.getMotore(id);}

    @PostMapping("/motori")
    public void addMotore(@RequestBody Motore motore) {motoreService.addMotore(motore);}

    @PutMapping("/motore/{id}")
    public void updateMotore(@PathVariable Integer id, @RequestBody Motore motore) {
        motoreService.updateMotore(id, motore);
    }

    @DeleteMapping("/motore/{id}")
    public void deleteMotore(@PathVariable Integer id) {motoreService.deleteMotore(id);}
}
