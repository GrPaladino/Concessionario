package com.app.concessionario.dto;

import lombok.Data;

import java.util.List;

//DTO - Data Transfer Object
@Data
public class AccessorioDTO {
    private Integer id;
    private String nome;
    private List<Integer> autoIds;
}
