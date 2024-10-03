package main.java.com.app.concessionario.controllers;

import main.java.com.app.concessionario.entity.Accessorio;
import main.java.com.app.concessionario.services.AccessorioService;
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
    public Accessorio getOptional(@PathVariable Integer id) {
        return optionalService.getOptional(id);
    }

    @PostMapping("/accessori")
    public void addOptional(@RequestBody Accessorio accessorio) {optionalService.addOptional(accessorio);}

    @PutMapping("/accessorio/{id}")
    public void updateOptional(@PathVariable Integer id, @RequestBody Accessorio accessorio) {
        optionalService.updateOptional(id, accessorio);
    }

    @DeleteMapping("/accessorio/{id}")
    public void deleteOptional(@PathVariable Integer id) {optionalService.deleteOptional(id);}


    // ---> logica da inserire nel service
//    @GetMapping("accDto/{id}")
//    public AccessoriDTO getAccessoriDto(@PathVariable Integer id) {
//        Accessorio a = optionalService.getOptional(id);
//        return AccessoriMapper.toDTO(a);
//    }

//    @PostMapping
//      public Accessori salvaDto(AccessoriDTO) {
//    sul db -> devo salvare l'entity = Accessori
}
