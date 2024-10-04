package com.app.concessionario.mapper;

import com.app.concessionario.dto.AccessorioDTO;
import com.app.concessionario.entity.Accessorio;
import com.app.concessionario.entity.Auto;

import java.util.List;
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


    public static Accessorio toEntity(AccessorioDTO accessorioDTO, List<Auto> autos) {

        //        crea nuovo accessorio
        Accessorio accessorio = new Accessorio();

//        setta l'id del accessorio prendendolo dal dto
        accessorio.setId(accessorioDTO.getId());

//        setta il nome del accessorio prendendolo dal dto
        accessorio.setNome(accessorioDTO.getNome());

//        itera sulla lista di autoID per settare
//        gli id delle auto che hanno questo accessorio
        accessorio.setAuto(accessorioDTO.getAutoIds().stream()
                .map(autoId -> autos.stream()
                        .filter(auto -> auto.getId().equals(autoId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Auto con ID " + autoId + " non trovata"))
                )
                .collect(Collectors.toList())
        );

        return accessorio;
    }
}
