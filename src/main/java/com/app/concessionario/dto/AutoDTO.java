package com.app.concessionario.dto;

import com.app.concessionario.entity.Accessorio;
import com.app.concessionario.entity.Cliente;
import com.app.concessionario.entity.Concessionario;
import com.app.concessionario.entity.Motore;
import lombok.Data;

import java.util.List;

@Data
public class AutoDTO {
    private Integer id;

    private String brand;

    private String modello;

    private String colore;

    private String stato;

    private String carrozzeria;

    private Boolean isVentuta;

    private Integer concessionarioId;

    private Integer clienteId;

    private List<Integer> motoriIds;

    private List<Integer> accessoriIds;

}
