package com.app.concessionario.mapper;

import com.app.concessionario.dto.ConcessionarioDTO;
import com.app.concessionario.entity.Auto;
import com.app.concessionario.entity.Concessionario;

import java.util.List;
import java.util.stream.Collectors;

public class ConcessionarioMapper {

    public static ConcessionarioDTO toDTO(Concessionario concessionario) {

        //        crea nuovo dto
        ConcessionarioDTO dto = new ConcessionarioDTO();

//        setta l'id del dto prendendolo dall'entity
        dto.setId(concessionario.getId());

//        setta il nome del dto prendendolo dall'entity
        dto.setNome(concessionario.getNome());

//        setta l'indirizzo del dto prendendolo dall'entity
        dto.setIndirizzo(concessionario.getIndirizzo());

//        setta la p_iva
        dto.setP_iva(concessionario.getP_iva());

//        setta la lista di auto
        dto.setAutoIds(concessionario.getAutos().stream().map(Auto::getId).collect(Collectors.toList()));

        return dto;
    }

    public static Concessionario toEntity(ConcessionarioDTO concessionarioDTO, List<Auto> autos) {

//        crea un nuovo concessionario
        Concessionario concessionario = new Concessionario();

//        setta l'id del concessionario prendendolo dal dto
        concessionario.setId(concessionario.getId());

//        setta il nome del concessionario prendendolo dal dto
        concessionario.setNome(concessionarioDTO.getNome());

//        setta l'indirizzo prendendolo dal dto
        concessionario.setIndirizzo(concessionarioDTO.getIndirizzo());

//        setta la p_iva prendendola dal dto
        concessionario.setP_iva(concessionarioDTO.getP_iva());

//        itera sulla lista delle auto per settare gli id
//        delle auto presenti nel concessionario

        concessionario.setAutos(concessionarioDTO.getAutoIds().stream()
                .map(autoId -> autos.stream()
                        .filter(auto -> auto.getId().equals(autoId))
                        .findFirst().orElseThrow(() -> new IllegalArgumentException("Auto con ID " + autoId + " non trovata"))
                ).collect(Collectors.toList())
        );

        return concessionario;
    }
}
