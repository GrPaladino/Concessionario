package com.app.concessionario.services;

import com.app.concessionario.entity.Motore;
import com.app.concessionario.repositories.MotoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoreService {

    @Autowired
    private MotoreRepository motoreRepository;

    public List<Motore> getMotori() {
        return motoreRepository.findAll();
    }

    public Motore getMotore(Integer id) {
        Optional<Motore> motore = motoreRepository.findById(id);
        return motore.orElse(null);
    }

    public void addMotore(Motore motore) {
        motoreRepository.save(motore);
    }

    public void updateMotore(Integer id, Motore motore) {
        motore.setId(id);
        motoreRepository.save(motore);
    }

    public void deleteMotore(Integer id) {
        motoreRepository.deleteById(id);
    }
}