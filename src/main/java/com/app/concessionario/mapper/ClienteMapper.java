package com.app.concessionario.mapper;

import com.app.concessionario.dto.ClienteDTO;
import com.app.concessionario.entity.Cliente;
import com.app.concessionario.entity.Concessionario;

import java.util.List;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {

//        crea nuovo dto
        ClienteDTO dto = new ClienteDTO();

//        settaggio parametri prendendoli dall'entity

        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCognome(cliente.getCognome());
        dto.setEmail(cliente.getEmail());
        dto.setTelefono(cliente.getTelefono());

        if (cliente.getConcessionario() != null) {
            if (cliente.getConcessionario().getId() != null)
                dto.setConcessionarioId(cliente.getConcessionario().getId());
        }

        return dto;
    }

    public static Cliente toEntity(ClienteDTO clienteDTO, List<Concessionario> concessionari) {

//        crea nuovo cliente
        Cliente cliente = new Cliente();

//        setto i dati del nuovo cliente prendendoli dal dto
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setCognome(clienteDTO.getCognome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());

//        setto i dati del concessionario ricevendo solo l'id
        for (Concessionario c : concessionari) {
            if (c.getId().equals(clienteDTO.getConcessionarioId()))
                cliente.setConcessionario(c);

        }

        return cliente;
    }
}
