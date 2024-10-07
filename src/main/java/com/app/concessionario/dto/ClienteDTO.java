package com.app.concessionario.dto;

import com.app.concessionario.entity.Concessionario;
import lombok.Data;

@Data
public class ClienteDTO {

    private Integer id;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private Integer concessionarioId;
}
