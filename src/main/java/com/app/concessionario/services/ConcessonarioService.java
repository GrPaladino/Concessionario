package com.app.concessionario.services;

import com.app.concessionario.dto.AutoDTO;
import com.app.concessionario.dto.ConcessionarioDTO;
import com.app.concessionario.entity.Auto;
import com.app.concessionario.entity.Concessionario;
import com.app.concessionario.mapper.AutoMapper;
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

//    chiamata post per creare un nuovo concessionario
//    #### TODO GESTIRE NUOVO CONC CON STESSO ID O P_IVA
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

//    chiamata per eliminare un concessionario
//    #### TODO GESTIRE ID NON PRESENTE
    public void deleteConcessionario(Integer id) {
    concessionarioRepository.deleteById(id);
}


//    METODO PER RITORNARE LA LISTA DI AUTO PRESENTI NEL CONCESSONARIO
    public List<AutoDTO> getAutoPerConcessionario(Integer concessionarioId) {
        List<Auto> autos = autoRepository.findAll();
        List<AutoDTO> newAutoList = new ArrayList<>();
        for (Auto a : autos) {
            if (a.getConcessionario().getId().equals(concessionarioId)) {
                AutoDTO newAuto = AutoMapper.toDTO(a);
                newAutoList.add(newAuto);
            }
        }
        return newAutoList;
    }


}

