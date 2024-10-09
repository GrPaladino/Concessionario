package com.app.concessionario.mapper;


import com.app.concessionario.dto.AutoDTO;
import com.app.concessionario.entity.*;
import com.app.concessionario.utils.enumerate.Carrozzeria;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class AutoMapper {

    public static AutoDTO toDTO(Auto auto) {

//        crea nuovo dto
        AutoDTO dto = new AutoDTO();

//        setta l'id del dto prendendolo dall'entity
        dto.setId(auto.getId());

//        setta il brand del dto prendendolo dall'entity
        dto.setBrand(auto.getBrand());

//        setta il modello del dto prendendolo dall'entity
        dto.setModello(auto.getModello());

//        setta il colore del dto prendendolo dall'entity
        dto.setColore(auto.getColore());

        //        setta la carrozzeria del dto prendendola dall'entity e controllando negli ENNUM
        for (Carrozzeria c : Carrozzeria.values()) {
            if (c.name().toLowerCase(Locale.ROOT).matches((auto.getCarrozzeria()))) {
                dto.setCarrozzeria(auto.getCarrozzeria());
            }
        }

        //        setta isVenduta del dto prendendolo dall'entity
        dto.setIsVentuta(auto.getIsVentuta());

        //        setta il concessionarioId del dto prendendolo dall'entity
        dto.setConcessionarioId(auto.getConcessionario().getId());

        //        setta l'id del cliente del dto prendendolo dall'entity
        Optional<Cliente> cli = Optional.ofNullable(auto.getCliente());
        if (cli.isPresent()) {
            dto.setClienteId(auto.getCliente().getId());
        }

        //        setta le motorizzazioni del dto prendendole dall'entity
        dto.setMotoriIds(auto.getMotori().stream().map(Motore::getId).collect(Collectors.toList()));

        //        setta gli accessori del dto prendendoli dall'entity
        dto.setAccessoriIds(auto.getAccessori().stream().map(Accessorio::getId).collect(Collectors.toList()));

        return dto;
    }



    public static Auto toEntity(AutoDTO autoDTO, List<Motore> motori, List<Accessorio> accessori, List<Cliente> clienti, List<Concessionario> concessionari) {

//        crea nuova auto
        Auto auto = new Auto();
//        setta l'id prendendolo dal dto
        auto.setId(autoDTO.getId());

        //        setta il brand prendendolo dal dto
        auto.setBrand(autoDTO.getBrand());

        //        setta il modello prendendolo dal dto
        auto.setModello(autoDTO.getModello());

        //        setta il colore prendendolo dal dto
        auto.setColore(autoDTO.getColore());

        //        setta lo stato prendendolo dal dto
        auto.setStato(autoDTO.getStato());

        //        setta la carrozzeria prendendolo dal dto e controllando se é presente negli ENUM
        for (Carrozzeria c : Carrozzeria.values()) {
            if (c.name().toLowerCase(Locale.ROOT).matches((autoDTO.getCarrozzeria()))) {
                auto.setCarrozzeria(autoDTO.getCarrozzeria());
            }
        }

        //        setta il concessionario prendendo l'id dal dto
        for (Concessionario c : concessionari) {
            if (c.getId().equals(autoDTO.getConcessionarioId())) {
                auto.setConcessionario(c);
            }
        }

        //        setta il cliente prendendo l'id dal dto
        for (Cliente c : clienti) {
            if (c.getId().equals(autoDTO.getClienteId())) {
                auto.setCliente(c);
            }
        }

        //        setta le motorizzazioni prendendolo dal dto
        auto.setMotori(autoDTO.getMotoriIds().stream()
                .map(motoriId -> motori.stream()
                        .filter(motore -> motore.getId().equals(motoriId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Motore con ID " + motoriId + " non trovato"))
                ).collect(Collectors.toList()));

        //        setta gli accessori prendendolo dal dto
        auto.setAccessori(autoDTO.getAccessoriIds().stream()
                .map(accessoriId -> accessori.stream()
                        .filter(accessorio -> accessorio.getId().equals(accessoriId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Accessorio con ID " + accessoriId + " non trovato"))
                ).collect(Collectors.toList())

        );

        return auto;

    }
}
