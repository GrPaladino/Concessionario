package main.java.com.app.concessionario.mapper;

import lombok.val;
import main.java.com.app.concessionario.dto.AccessoriDTO;
import main.java.com.app.concessionario.entity.Accessorio;
import main.java.com.app.concessionario.entity.Auto;

import java.util.ArrayList;
import java.util.List;

public class AccessoriMapper {

    public static AccessoriDTO toDTO(Accessorio accessorio) {
        AccessoriDTO dto = new AccessoriDTO();
        dto.setId(accessorio.getId());
        dto.setNome(accessorio.getNome());
        List<Integer> idsList = new ArrayList<>();
        for (Auto a: accessorio.getAuto()){
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
