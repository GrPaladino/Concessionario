package com.app.concessionario.services;

import com.app.concessionario.dto.ClienteDTO;
import com.app.concessionario.dto.MotoreDTO;
import com.app.concessionario.entity.Auto;
import com.app.concessionario.entity.Motore;
import com.app.concessionario.mapper.MotoreMapper;
import com.app.concessionario.repositories.AutoRepository;
import com.app.concessionario.repositories.MotoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MotoreService {

    @Autowired
    private MotoreRepository motoreRepository;

    @Autowired
    private AutoRepository autoRepository;

//    public List<Motore> getMotori() {
//        return motoreRepository.findAll();
//    }
//
//    public Motore getMotore(Integer id) {
//        Optional<Motore> motore = motoreRepository.findById(id);
//        return motore.orElse(null);
//    }
//
//    public void addMotore(Motore motore) {
//        motoreRepository.save(motore);
//    }
//
//    public void updateMotore(Integer id, Motore motore) {
//        motore.setId(id);
//        motoreRepository.save(motore);
//    }

    public void deleteMotore(Integer id) {
        motoreRepository.deleteById(id);
    }


//                              CHIAMATE DTO

//    chiamata get per tutti i motori
    public List<MotoreDTO> getMotoriDTO() {
        List<MotoreDTO> motoriDTO = new ArrayList<>();
        List<Motore> motori = motoreRepository.findAll();

        for (Motore m : motori) {
            MotoreDTO motoreDTO = MotoreMapper.toDTO(m);
            motoriDTO.add(motoreDTO);
        }
        return motoriDTO;
    }

//    chiamata get per un singolo motore
    public MotoreDTO getMotoreDTO(Integer id) {
        Optional<Motore> m = motoreRepository.findById(id);
        return MotoreMapper.toDTO(m.get());
    }

//    chiamata post per creare un nuovo motore
    public void addMotoreDTO(MotoreDTO motoreDTO) {
        List<Auto> auto = autoRepository.findAll();
        Motore newMotore = MotoreMapper.toEntity(motoreDTO, auto);
        motoreRepository.save(newMotore);
    }

//    chiamata put per modificare un motore
    public void updateMotoreDTO(Integer id, MotoreDTO motoreDTO) {
        List<Auto> auto = autoRepository.findAll();
        Motore newMotore = MotoreMapper.toEntity(motoreDTO, auto);
        newMotore.setId(id);
        motoreRepository.save(newMotore);
    }
}