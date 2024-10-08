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
    public AccessorioDTO getAccessorioDto(Integer id) {
        Optional<Accessorio> a = accessorioRepository.findById(id);
        return AccessorioMapper.toDTO(a.get());
    }



//    chiamata post per creare un nuovo accessorio
//    ###### TODO gestire creazione accessorio con stesso id
    public void addAccessorioDTO(AccessorioDTO accessorioDTO) {
        List<Auto> autos = autoRepository.findAll();
        Accessorio newAccessorio = AccessorioMapper.toEntity(accessorioDTO, autos);
        accessorioRepository.save(newAccessorio);
    }

//    chiamata put per update accessorio

    public void updateAccessorioDTO(Integer id, AccessorioDTO accessorioDTO) {
        List<Auto> autos = autoRepository.findAll();
        Accessorio newAccessorio = AccessorioMapper.toEntity(accessorioDTO, autos);
        newAccessorio.setId(id);
        accessorioRepository.save(newAccessorio);
    }

//    chiamata per eliminare un accessorio
//    #### TODO GESTIRE ID NON PRESENTE
    public void deleteAccessorio(Integer id) {
        accessorioRepository.deleteById(id);
    }

}
