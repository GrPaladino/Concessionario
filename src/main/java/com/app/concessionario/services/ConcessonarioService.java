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
    public ConcessionarioDTO getConcessionarioDTO(Integer id) throws Exception {

        List<Integer> concessionariIds = concessionarioRepository.findAll().stream().map(Concessionario::getId).toList();
        if (!concessionariIds.contains(id))
            throw new Exception("L'id inserito non é corretto");

        Optional<Concessionario> c = concessionarioRepository.findById(id);
        return ConcessionarioMapper.toDTO(c.get());
    }

//    chiamata post per creare un nuovo concessionario
    public void addConcessionarioDTO(ConcessionarioDTO concessionarioDTO) throws Exception {
        List<Integer> concessionariIds = concessionarioRepository.findAll().stream().map(Concessionario::getId).toList();
        List<String> pIvas = concessionarioRepository.findAll().stream().map(Concessionario::getP_iva).toList();
        if (concessionariIds.contains(concessionarioDTO.getId())) {
            throw new Exception("L'id inserito non è valido");
        } else if (concessionarioDTO.getNome() == null) {
            throw new Exception("Il campo nome non può essere vuoto");
        } else if (concessionarioDTO.getNome().length() > 100) {
            throw new Exception("La lunghezza del campo nome non può superare 100 caratteri");
        } else if (concessionarioDTO.getIndirizzo().length() > 200) {
            throw new Exception("La lunghezza del campo indirizzo non può superare 200 caratteri");
        } else if (concessionarioDTO.getP_iva() == null) {
            throw new Exception("Il campo p_iva non può essere vuoto");
        } else if (concessionarioDTO.getP_iva().length() > 11) {
            throw new Exception("La lunghezza del campo p_iva non può superare 11 caratteri");
        }else if (pIvas.contains(concessionarioDTO.getP_iva())) {
            throw new Exception("Il campo p_iva è già esistente");
        }
        List<Auto> autos = autoRepository.findAll();
        Concessionario newConcessionario = ConcessionarioMapper.toEntity(concessionarioDTO, autos);
        concessionarioRepository.save(newConcessionario);
    }

//    chiamata put per update concessionario
    public void updateConcessionarioDTO(Integer id, ConcessionarioDTO concessionarioDTO) throws Exception {
        List<Integer> concessionariIds = concessionarioRepository.findAll().stream().map(Concessionario::getId).toList();
        List<String> pIvas = concessionarioRepository.findAll().stream().map(Concessionario::getP_iva).toList();
        if (concessionariIds.contains(id)) {
            if (concessionarioDTO.getNome() == null) {
                throw new Exception("Il campo nome non può essere vuoto");
            } else if (concessionarioDTO.getNome().length() > 100) {
                throw new Exception("La lunghezza del campo nome non può superare 100 caratteri");
            } else if (concessionarioDTO.getIndirizzo().length() > 200) {
                throw new Exception("La lunghezza del campo indirizzo non può superare 200 caratteri");
            } else if (concessionarioDTO.getP_iva() == null) {
                throw new Exception("Il campo p_iva non può essere vuoto");
            } else if (concessionarioDTO.getP_iva().length() > 11) {
                throw new Exception("La lunghezza del campo p_iva non può superare 11 caratteri");
            }else if (pIvas.contains(concessionarioDTO.getP_iva())) {
                throw new Exception("Il campo p_iva è già esistente");
            }
            List<Auto> autos = autoRepository.findAll();
            Concessionario newConcessionario = ConcessionarioMapper.toEntity(concessionarioDTO, autos);
            newConcessionario.setId(id);
            concessionarioRepository.save(newConcessionario);
        } else {
            throw new Exception("L'id inserito non é corretto");
        }

    }

//    chiamata per eliminare un concessionario
    public void deleteConcessionario(Integer id) throws Exception {
        List<Integer> concessionariIds = concessionarioRepository.findAll().stream().map(Concessionario::getId).toList();
        if (concessionariIds.contains(id)) {
            concessionarioRepository.deleteById(id);
        } else {
            throw new Exception("Concessionario selezionato non valido");
        }
}


//    METODO PER RITORNARE LA LISTA DI AUTO PRESENTI NEL CONCESSONARIO
    public List<AutoDTO> getAutoPerConcessionario(Integer id) throws Exception {
        List<Integer> concessionariIds = concessionarioRepository.findAll().stream().map(Concessionario::getId).toList();
        Optional<Concessionario> c = concessionarioRepository.findById(id);
        if (!concessionariIds.contains(id)) {
            throw new Exception("Concessionario selezionato non valido");
        } else if (c.get().getAutos().isEmpty()) {
            throw new Exception("Il concessionario selezionato non ha nessuna auto");
        }
        List<Auto> autos = autoRepository.findAll();
        List<AutoDTO> newAutoList = new ArrayList<>();
        for (Auto a : autos) {
            if (a.getConcessionario().getId().equals(id)) {
                AutoDTO newAuto = AutoMapper.toDTO(a);
                newAutoList.add(newAuto);
            }
        }
        return newAutoList;
    }


}

