package com.app.concessionario.services;

import com.app.concessionario.dto.AutoDTO;
import com.app.concessionario.entity.Accessorio;
import com.app.concessionario.entity.Auto;
import com.app.concessionario.entity.Motore;
import com.app.concessionario.mapper.AutoMapper;
import com.app.concessionario.repositories.AccessorioRepository;
import com.app.concessionario.repositories.AutoRepository;
import com.app.concessionario.repositories.MotoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private MotoreRepository motoreRepository;
    @Autowired
    private AccessorioRepository accessorioRepository;

//    public List<Auto> getAutos() {
//        return autoRepository.findAll();
//    }

//    public Auto getAuto(Integer id) {
//        Optional<Auto> auto = autoRepository.findById(id);
//        return auto.orElse(null);
//    }

//    public void addAuto(Auto auto) {
//        autoRepository.save(auto);
//    }

//    public void updateAuto(Integer id, Auto auto) {
//        auto.setId(id);
//        autoRepository.save(auto);
//    }

    public void deleteAuto(Integer id) {
        autoRepository.deleteById(id);
    }


//                                CHIAMATE DTO
//
//    chiamata get di tutti le auto
    public List<AutoDTO> getAutosDTO() {
        List<AutoDTO> autosDTO = new ArrayList<>();
        List<Auto> auto = autoRepository.findAll();
        for (Auto a : auto) {
            AutoDTO autoDTO = AutoMapper.toDTO(a);
            autosDTO.add(autoDTO);
        }
        return autosDTO;
    }

//    chiamata get per una singola auto
    public AutoDTO getAutoDTO(Integer id) {
        Optional<Auto> a = autoRepository.findById(id);
        return AutoMapper.toDTO(a.get());
    }



//    chiamata post per creare una nuova auto
    public void addAutoDTO(AutoDTO autoDTO) {
        List<Motore> motori = motoreRepository.findAll();
        List<Accessorio> accessori = accessorioRepository.findAll();
        Auto newAuto = AutoMapper.toEntity(autoDTO, motori, accessori);
        autoRepository.save(newAuto);
    }
//
////    chiamata put per update auto
//
    public void updateAutoDTO(Integer id, AutoDTO autoDTO) {
        List<Motore> motori = motoreRepository.findAll();
        List<Accessorio> accessori = accessorioRepository.findAll();
        Auto newAuto = AutoMapper.toEntity(autoDTO, motori, accessori);
        newAuto.setId(id);
        autoRepository.save(newAuto);
    }
}
