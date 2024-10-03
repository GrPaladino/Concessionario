package com.app.concessionario.mapper;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.entity.Accessorio;
import com.app.concessionario.entity.Auto;

import java.util.Optional;
import java.util.stream.Collectors;

public class AccessorioMapper {

    public static AccessorioDTO toDTO(Accessorio accessorio) {

//        crea nuovo dto
        AccessorioDTO dto = new AccessorioDTO();

//        setta l'id del dto prendendolo dall'entity
        dto.setId(accessorio.getId());

//        setta il nome del dto prendendolo dall'entity
        dto.setNome(accessorio.getNome());

//      itera sulla lista di entità(auto nella relazione con accessorio in questo caso),
//      prende gli id della auto che hanno quell'accessorio
//      e li inserisce nella lista autoIds
        dto.setAutoIds(accessorio.getAuto().stream().map(Auto::getId).collect(Collectors.toList()));

        return dto;
    }

    public static Accessorio toEntity(AccessorioDTO accessorioDTO) {

    }
}
