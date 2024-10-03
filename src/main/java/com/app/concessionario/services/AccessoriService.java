package main.java.com.app.concessionario.services;

import main.java.com.app.concessionario.entity.Accessori;
import main.java.com.app.concessionario.repositories.AccessoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessoriService {

    @Autowired
    private AccessoriRepository optionalRepository;

    public List<Accessori> getOptionals() {
        return optionalRepository.findAll();
    }

    public Accessori getOptional(Integer id) {
        Optional<Accessori> optional = optionalRepository.findById(id);
        return optional.orElse(null);
    }

    public void addOptional(Accessori optional) {
        optionalRepository.save(optional);
    }

    public void updateOptional(Integer id, Accessori optional) {
        optional.setId(id);
        optionalRepository.save(optional);
    }

    public void deleteOptional(Integer id) {
        optionalRepository.deleteById(id);
    }
}
