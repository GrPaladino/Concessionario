package main.java.com.app.concessionario.controllers;

import main.java.com.app.concessionario.dto.AccessoriDTO;
import main.java.com.app.concessionario.entity.Accessori;
import main.java.com.app.concessionario.mapper.AccessoriMapper;
import main.java.com.app.concessionario.services.AccessoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccessoriController {

    @Autowired
    private AccessoriService optionalService;

    @GetMapping("/optionals")
    public List<Accessori> getOptionals() {return optionalService.getOptionals();}

    @GetMapping("/optional/{id}")
    public Accessori getOptional(@PathVariable Integer id) {
        return optionalService.getOptional(id);
    }

    @PostMapping("/optionals")
    public void addOptional(@RequestBody Accessori optional) {optionalService.addOptional(optional);}

    @PutMapping("/optional/{id}")
    public void updateOptional(@PathVariable Integer id, @RequestBody Accessori optional) {
        optionalService.updateOptional(id, optional);
    }

    @DeleteMapping("/optional/{id}")
    public void deleteOptional(@PathVariable Integer id) {optionalService.deleteOptional(id);}


    // ---> logica da inserire nel service
    @GetMapping("accDto/{id}")
    public AccessoriDTO getAccessoriDto(@PathVariable Integer id) {
        Accessori a = optionalService.getOptional(id);
        return AccessoriMapper.toDTO(a);
    }

//    @PostMapping
//      public Accessori salvaDto(AccessoriDTO) {
//    sul db -> devo salvare l'entity = Accessori
}
