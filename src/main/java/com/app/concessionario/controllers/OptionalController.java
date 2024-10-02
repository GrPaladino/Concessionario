package main.java.com.app.concessionario.controllers;

import main.java.com.app.concessionario.entity.Motore;
import main.java.com.app.concessionario.entity.Optional;
import main.java.com.app.concessionario.services.OptionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionalController {

    @Autowired
    private OptionalService optionalService;

    @GetMapping("/optionals")
    public List<Optional> getOptionals() {return optionalService.getOptionals();}

    @GetMapping("/optional/{id}")
    public Optional getOptional(@PathVariable Integer id) {return optionalService.getOptional(id);}

    @PostMapping("/optionals")
    public void addOptional(@RequestBody Optional optional) {optionalService.addOptional(optional);}

    @PutMapping("/optional/{id}")
    public void updateOptional(@PathVariable Integer id, @RequestBody Optional optional) {
        optionalService.updateOptional(id, optional);
    }

    @DeleteMapping("/optional/{id}")
    public void deleteOptional(@PathVariable Integer id) {optionalService.deleteOptional(id);}
}
