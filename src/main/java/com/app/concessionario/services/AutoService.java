package main.java.com.app.concessionario.services;

import main.java.com.app.concessionario.entity.Auto;
import main.java.com.app.concessionario.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> getAutos() {
        return autoRepository.findAll();
    }

    public Auto getAuto(Integer id) {
        Optional<Auto> auto = autoRepository.findById(id);
        return auto.orElse(null);
    }

    public void addAuto(Auto auto) {
        autoRepository.save(auto);
    }

    public void updateAuto(Integer id, Auto auto) {
        autoRepository.save(auto);
    }

    public void deleteAuto(Integer id) {
        autoRepository.deleteById(id);
    }
}
