package com.app.concessionario.services;

import com.app.concessionario.dto.ConcessionarioDTO;
import com.app.concessionario.entity.Auto;
import com.app.concessionario.entity.Concessionario;
import com.app.concessionario.mapper.ConcessionarioMapper;
import com.app.concessionario.repositories.AutoRepository;
import com.app.concessionario.repositories.ConcessionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConcessonarioService {

    @Autowired
    ConcessionarioRepository concessionarioRepository;

    @Autowired
    AutoRepository autoRepository;


//    public List<Concessionario> getConcessionari() {
//        return concessionarioRepository.findAll();
//    }
//
//    public Concessionario getConcessionario(Integer id) {
//        Optional<Concessionario> concessionario = concessionarioRepository.findById(id);
//        return concessionario.orElse(null);
//    }

//    public void addConcessionario(Concessionario concessionario) {
//        concessionarioRepository.save(concessionario);
//    }
//
//    public void updateConcessionario(Integer id, Concessionario concessionario) {
//        concessionario.setId(id);
//        concessionarioRepository.save(concessionario);
//    }

    public void deleteConcessionario(Integer id) {
        concessionarioRepository.deleteById(id);
    }



//                              CHIAMATE DTO

    //    chiamata get di tutti gli accessori
    public List<ConcessionarioDTO> getConcessionariDTO() {
        List<ConcessionarioDTO> concessionariDTO = new ArrayList<>();
        List<Concessionario> concessionari = concessionarioRepository.findAll();
        for (Concessionario c : concessionari) {
            ConcessionarioDTO concessionarioDTO = ConcessionarioMapper.toDTO(c);
            concessionariDTO.add(concessionarioDTO);
        }
        return concessionariDTO;
    }

//    chiamata per un singolo concessionario
    public ConcessionarioDTO getConcessionarioDTO(Integer id) {
        Optional<Concessionario> c = concessionarioRepository.findById(id);
        return ConcessionarioMapper.toDTO(c.get());
    }

//    chiamata post per creare un nuovo concessionario ##### NON RITORNA LA LISTA DELLE AUTO
    public void addConcessionarioDTO(ConcessionarioDTO concessionarioDTO) {
        List<Auto> autos = autoRepository.findAll();
        Concessionario newConcessionario = ConcessionarioMapper.toEntity(concessionarioDTO, autos);
        concessionarioRepository.save(newConcessionario);
    }

//    chiamata put per update concessionario
    public void updateConcessionarioDTO(Integer id, ConcessionarioDTO concessionarioDTO) {
        List<Auto> autos = autoRepository.findAll();
        Concessionario newConcessionario = ConcessionarioMapper.toEntity(concessionarioDTO, autos);
        newConcessionario.setId(id);
        concessionarioRepository.save(newConcessionario);

    }

}

