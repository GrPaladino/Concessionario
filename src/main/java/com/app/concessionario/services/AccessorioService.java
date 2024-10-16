package com.app.concessionario.services;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.entity.Accessorio;
import com.app.concessionario.entity.Auto;
import com.app.concessionario.mapper.AccessorioMapper;
import com.app.concessionario.repositories.AccessorioRepository;
import com.app.concessionario.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccessorioService {

    @Autowired
    private AccessorioRepository accessorioRepository;

    @Autowired
    public AutoRepository autoRepository;


//                              CHIAMATE DTO

//    chiamata get di tutti gli accessori
    public List<AccessorioDTO> getAccessoriDTO() {
        List<AccessorioDTO> accessoriDTO = new ArrayList<>();
        List<Accessorio> accessori = accessorioRepository.findAll();
        for (Accessorio a : accessori) {
            AccessorioDTO accessorioDTO = AccessorioMapper.toDTO(a);
            accessoriDTO.add(accessorioDTO);
        }
        return accessoriDTO;
    }

//    chiamata get per un singolo accessorio
    public AccessorioDTO getAccessorioDto(Integer id) throws Exception {
        List<Integer> accIds = accessorioRepository.findAll().stream().map(Accessorio::getId).toList();
        if (!accIds.contains(id))
            throw new Exception("L'id inserito non è corretto");

        Optional<Accessorio> a = accessorioRepository.findById(id);
        return AccessorioMapper.toDTO(a.get());
    }



//    chiamata post per creare un nuovo accessorio
    public void addAccessorioDTO(AccessorioDTO accessorioDTO) throws Exception {
        List<Integer> accessoriIds = accessorioRepository.findAll().stream().map(Accessorio::getId).toList();
        if (accessoriIds.contains(accessorioDTO.getId())) {
            throw new Exception("L'id inserito non è valido");
        } else if (accessorioDTO.getNome() == null) {
            throw new Exception("Il campo nome non può essere vuoto");
        } else if (accessorioDTO.getNome().length() > 100) {
            throw new Exception("La lunghezza del nome non può superare i 100 caratteri");
        }

        List<Auto> autos = autoRepository.findAll();
        Accessorio newAccessorio = AccessorioMapper.toEntity(accessorioDTO, autos);
        accessorioRepository.save(newAccessorio);
    }

    //    chiamata put per update accessorio
    public void updateAccessorioDTO(Integer id, AccessorioDTO accessorioDTO) throws Exception {
        List<Integer> accessoriIds = accessorioRepository.findAll().stream().map(Accessorio::getId).toList();
        if (accessoriIds.contains(id)) {
            if (accessorioDTO.getNome() == null) {
                throw new Exception("Il campo nome non può essere vuoto");
            } else if (accessorioDTO.getNome().length() > 100) {
                throw new Exception("La lunghezza del nome non può superare i 100 caratteri");
            }
            List<Auto> autos = autoRepository.findAll();
            Accessorio newAccessorio = AccessorioMapper.toEntity(accessorioDTO, autos);
            newAccessorio.setId(id);
            accessorioRepository.save(newAccessorio);
        } else {
            throw new Exception("L'id inserito non è valido");
        }
    }

//    chiamata per eliminare un accessorio
    public void deleteAccessorio(Integer id) throws Exception {
        List<Integer> accessoriIds = accessorioRepository.findAll().stream().map(Accessorio::getId).toList();
        if (accessoriIds.contains(id)) {
        accessorioRepository.deleteById(id);
        } else {
            throw new Exception("Accessorio selezionato non valido");
        }
    }

}
