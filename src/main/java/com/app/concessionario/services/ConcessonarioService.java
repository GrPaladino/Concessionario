package main.java.com.app.concessionario.services;

import main.java.com.app.concessionario.entity.Concessionario;
import main.java.com.app.concessionario.repositories.ConcessionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcessonarioService {

    @Autowired
    ConcessionarioRepository concessionarioRepository;


    public List<Concessionario> getConcessionari() {
        return concessionarioRepository.findAll();
    }

    public Concessionario getConcessionario(Integer id) {
        Optional<Concessionario> concessionario = concessionarioRepository.findById(id);
        return concessionario.orElse(null);
    }

    public void addConcessionario(Concessionario concessionario) {
        concessionarioRepository.save(concessionario);
    }

    public void updateConcessionario(Integer id, Concessionario concessionario) {
        concessionario.setId(id);
        concessionarioRepository.save(concessionario);
    }

    public void deleteConcessionario(Integer id) {
        concessionarioRepository.deleteById(id);
    }
}

