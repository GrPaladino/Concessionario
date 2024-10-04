package com.app.concessionario.dto;

import com.app.concessionario.entity.Auto;
import lombok.Data;

import java.util.List;

@Data
public class ConcessionarioDTO {
    private Integer id;
    private String nome;
    private String indirizzo;
    private String p_iva;
    private List<Integer> autoIds;
}
