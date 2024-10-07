package com.app.concessionario.mapper;

import com.app.concessionario.dto.MotoreDTO;
import com.app.concessionario.entity.Auto;
import com.app.concessionario.entity.Motore;

import java.util.List;
import java.util.stream.Collectors;

public class MotoreMapper {

        public static MotoreDTO toDTO(Motore motore) {

//        crea nuovo dto
        MotoreDTO dto = new MotoreDTO();

//        settaggio parametri prendendoli dall'entity

        dto.setId(motore.getId());
        dto.setPotenza(motore.getPotenza());
        dto.setCilindrata(motore.getCilindrata());
        dto.setCarburante(motore.getCarburante());

        dto.setAutoIds(motore.getAuto().stream().map(Auto::getId).collect(Collectors.toList()));


        return dto;
    }


    public static Motore toEntity(MotoreDTO motoreDTO, List<Auto> autos) {

//            crea nuovo motore
        Motore motore = new Motore();

//        setta i parametri del nuovo motore prendendoli dal dto
        motore.setId(motoreDTO.getId());
        motore.setPotenza(motoreDTO.getPotenza());
        motore.setCilindrata(motoreDTO.getCilindrata());
        motore.setCarburante(motoreDTO.getCarburante());

//        setta la lista di auto che hanno questo motore
        if (motoreDTO.getAutoIds() != null) {
            motore.setAuto(motoreDTO.getAutoIds().stream()
                    .map(autoId -> autos.stream()
                            .filter(auto -> auto.getId().equals(autoId))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Auto con ID " + autoId + " non trovata"))
                    ).collect(Collectors.toList())
            );
        }

        return motore;
    }
}
