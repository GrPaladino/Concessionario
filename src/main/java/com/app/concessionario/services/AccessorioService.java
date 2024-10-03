package main.java.com.app.concessionario.services;

import main.java.com.app.concessionario.entity.Accessorio;
import main.java.com.app.concessionario.repositories.AccessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessorioService {

    @Autowired
    private AccessorioRepository accessorioRepository;

    public List<Accessorio> getOptionals() {
        return accessorioRepository.findAll();
    }

    public Accessorio getOptional(Integer id) {
        Optional<Accessorio> accessorio = accessorioRepository.findById(id);
        return accessorio.orElse(null);
    }

    public void addOptional(Accessorio accessorio) {
        accessorioRepository.save(accessorio);
    }

    public void updateOptional(Integer id, Accessorio accessorio) {
        accessorio.setId(id);
        accessorioRepository.save(accessorio);
    }

    public void deleteOptional(Integer id) {
        accessorioRepository.deleteById(id);
    }
}
