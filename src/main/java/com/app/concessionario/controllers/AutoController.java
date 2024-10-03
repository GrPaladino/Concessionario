package com.app.concessionario.controllers;

import com.app.concessionario.entity.Auto;
import com.app.concessionario.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping("/auto")
    public List<Auto> getAutos() {return autoService.getAutos();}

    @GetMapping("/auto/{id}")
    public Auto getAuto(@PathVariable Integer id) {return autoService.getAuto(id);}

    @PostMapping("/auto")
    public void addAuto(@RequestBody Auto auto) {autoService.addAuto(auto);}

    @PutMapping("/auto/{id}")
    public void updateAuto(@PathVariable Integer id, @RequestBody Auto auto) {
        autoService.updateAuto(id, auto);
    }

    @DeleteMapping("/auto/{id}")
    public void deleteAuto(@PathVariable Integer id) {autoService.deleteAuto(id);}
}
