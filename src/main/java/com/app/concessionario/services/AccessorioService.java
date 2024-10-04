package com.app.concessionario.services;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.entity.Accessorio;
import com.app.concessionario.entity.Auto;
import com.app.concessionario.mapper.AccessorioMapper;
import com.app.concessionario.repositories.AccessorioRepository;
import com.app.concessionario.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessorioService {

    @Autowired
    private AccessorioRepository accessorioRepository;

    @Autowired
    public AutoRepository autoRepository;

    public List<Accessorio> getOptionals() {
        return accessorioRepository.findAll();
    }

//    public Accessorio getOptional(Integer id) {
//        Optional<Accessorio> accessorio = accessorioRepository.findById(id);
//        return accessorio.orElse(null);
//
//    }

//    public void addOptional(Accessorio accessorio) {
//        accessorioRepository.save(accessorio);
//    }

    public void updateOptional(Integer id, Accessorio accessorio) {
        accessorio.setId(id);
        accessorioRepository.save(accessorio);
    }

    public void deleteOptional(Integer id) {
        accessorioRepository.deleteById(id);
    }

//    chiamata get DTO
    public AccessorioDTO getAccessorioDto(Integer id) {
        Optional<Accessorio> a = accessorioRepository.findById(id);
        return AccessorioMapper.toDTO(a.get());
    }



//    chiamata post DTO
    public void addAccessorioDTO(AccessorioDTO accessorioDTO) {
        List<Auto> autos = autoRepository.findAll();
        Accessorio newAccessorio = AccessorioMapper.toEntity(accessorioDTO, autos);
        accessorioRepository.save(newAccessorio);
    }
}
