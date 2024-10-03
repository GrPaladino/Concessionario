package com.app.concessionario.services;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.entity.Accessorio;
import com.app.concessionario.mapper.AccessorioMapper;
import com.app.concessionario.repositories.AccessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AccessorioService {

    @Autowired
    private AccessorioRepository accessorioRepository;

    public List<Accessorio> getOptionals() {
        return accessorioRepository.findAll();
    }

//    public Accessorio getOptional(Integer id) {
//        Optional<Accessorio> accessorio = accessorioRepository.findById(id);
//        return accessorio.orElse(null);
//
//    }

    public void addOptional(Accessorio accessorio) {
        accessorioRepository.save(accessorio);
    }

    public void updateOptional(Integer id, Accessorio accessorio) {
        accessorio.setId(id);
        accessorioRepository.save(accessorio);
    }

    public void deleteOptional(Integer id) {
        accessorioRepository.deleteById(id);
    }

//    chiamata DTO
//        @GetMapping("accDto/{id}")
//    public AccessorioDTO getAccessorioDto(Integer id) {
//        Accessorio a = accessorioRepository.findById(id);
//        return AccessorioMapper.toDTO(a);
//    }
}
