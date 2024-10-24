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

//                              CHIAMATE DTO

//    chiamata get per tutti i motori
    public List<MotoreDTO> getMotoriDTO() throws Exception {
        List<MotoreDTO> motoriDTO = new ArrayList<>();
        List<Motore> motori = motoreRepository.findAll();

        for (Motore m : motori) {
            MotoreDTO motoreDTO = MotoreMapper.toDTO(m);
            motoriDTO.add(motoreDTO);
        }
        if (motoriDTO.isEmpty())
            throw new Exception("Nessun motore presente");

        return motoriDTO;
    }

//    chiamata get per un singolo motore
    public MotoreDTO getMotoreDTO(Integer id) throws Exception {
        Optional<Motore> m = motoreRepository.findById(id);
        if (!m.isPresent())
            throw new Exception("L'id inserito non é corretto");

        return MotoreMapper.toDTO(m.get());
    }

//    chiamata post per creare un nuovo motore
    public void addMotoreDTO(MotoreDTO motoreDTO) throws Exception {
        Optional<Motore> m = motoreRepository.findById(motoreDTO.getId());

        if (m.isPresent())
            throw new Exception("L'id inserito non è valido");

        if (motoreDTO.getPotenza() == null)
            throw new Exception("Il campo potenza non può essere vuoto");

        if (motoreDTO.getCilindrata() == null)
            throw new Exception("Il campo cilindrata non può essere vuoto");

        if (motoreDTO.getCarburante() == null)
            throw new Exception("Il campo carburante non può essere vuoto");

        if (motoreDTO.getCarburante().length() > 20)
            throw new Exception("Il campo carburante non può superare i 20 caratteri");

        List<Auto> auto = autoRepository.findAll();
        Motore newMotore = MotoreMapper.toEntity(motoreDTO, auto);
        motoreRepository.save(newMotore);
    }

//    chiamata put per modificare un motore
    public void updateMotoreDTO(Integer id, MotoreDTO motoreDTO) throws Exception {
        Optional<Motore> m = motoreRepository.findById(id);

        if (m.isPresent()) {

            if (motoreDTO.getPotenza() == null)
                throw new Exception("Il campo potenza non può essere vuoto");

            if (motoreDTO.getCilindrata() == null)
                throw new Exception("Il campo cilindrata non può essere vuoto");

            if (motoreDTO.getCarburante() == null)
                throw new Exception("Il campo carburante non può essere vuoto");

            if (motoreDTO.getCarburante().length() > 20)
                throw new Exception("Il campo carburante non può superare i 20 caratteri");

            List<Auto> auto = autoRepository.findAll();
            Motore newMotore = MotoreMapper.toEntity(motoreDTO, auto);
            newMotore.setId(id);
            motoreRepository.save(newMotore);
        } else {
            throw new Exception("L'id inserito non é corretto");
        }

    }

//    chiamata patch
    public void patchMotoreDTO(Integer id, MotoreDTO patchMotoreDTO) throws Exception {
        Optional<Motore> m = motoreRepository.findById(id);

        if (m.isPresent()) {

            if (patchMotoreDTO.getPotenza() != null)
                m.get().setPotenza(patchMotoreDTO.getPotenza());

            if (patchMotoreDTO.getCilindrata() != null)
                m.get().setCilindrata(patchMotoreDTO.getCilindrata());

            if (patchMotoreDTO.getCarburante() != null) {
                if (patchMotoreDTO.getCarburante().length() > 20)
                    throw new Exception("Il campo carburante non può superare i 20 caratteri");

                m.get().setCarburante(patchMotoreDTO.getCarburante());
            }

            motoreRepository.save(m.get());
        } else {
            throw new Exception("L'id inserito non é corretto");
        }
    }

//    chiamata per eliminare un motore
    public void deleteMotore(Integer id) throws Exception {
        Optional<Motore> m = motoreRepository.findById(id);

        if (!m.isPresent())
            throw new Exception("Motore selezionato non valido");

        motoreRepository.deleteById(id);
}
}