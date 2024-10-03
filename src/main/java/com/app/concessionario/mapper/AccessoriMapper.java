package main.java.com.app.concessionario.mapper;

import lombok.val;
import main.java.com.app.concessionario.dto.AccessoriDTO;
import main.java.com.app.concessionario.entity.Accessori;
import main.java.com.app.concessionario.entity.Auto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccessoriMapper {

    public static AccessoriDTO toDTO(Accessori accessori) {
        AccessoriDTO dto = new AccessoriDTO();
        dto.setId(accessori.getId());
        dto.setNome(accessori.getNome());
        List<Integer> idsList = new ArrayList<>();
        for (Auto a: accessori.getAuto()){
            val ids = a.getId();
            idsList.add(ids);
        }
        dto.setAutoIds(idsList);
//        dto.setAutoIds(accessori.getAuto().stream().map(Auto::getId).collect(Collectors.toList()));
        return dto;
    }

//    public static Accessori toEntity(AccessoriDTO accessoriDTO) {
//
//    }
}
