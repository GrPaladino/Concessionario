package main.java.com.app.concessionario.dto;

import lombok.Data;

import java.util.List;

//DTO - Data Transfer Object
@Data
public class AccessoriDTO {
    private Integer id;
    private String nome;
    private List<Integer> autoIds;
}
