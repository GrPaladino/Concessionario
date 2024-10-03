package main.java.com.app.concessionario.services;

import main.java.com.app.concessionario.entity.Optional;
import main.java.com.app.concessionario.repositories.OptionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionalService {

    @Autowired
    private OptionalRepository optionalRepository;

    public List<Optional> getOptionals() {
        return optionalRepository.findAll();
    }

    public Optional getOptional(Integer id) {
        java.util.Optional<Optional> optional = optionalRepository.findById(id);
        return optional.orElse(null);
    }

    public void addOptional(Optional optional) {
        optionalRepository.save(optional);
    }

    public void updateOptional(Integer id, Optional optional) {
        optional.setId(id);
        optionalRepository.save(optional);
    }

    public void deleteOptional(Integer id) {
        optionalRepository.deleteById(id);
    }
}
