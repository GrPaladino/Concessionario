package com.app.concessionario.dto;

import lombok.Data;

import java.util.List;

@Data
public class MotoreDTO {

    private Integer id;
    private Integer potenza;
    private Double cilindrata;
    private String carburante;
    private List<Integer> autoIds;
}
