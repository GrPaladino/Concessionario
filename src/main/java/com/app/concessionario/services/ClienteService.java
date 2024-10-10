package com.app.concessionario.services;

import com.app.concessionario.dto.ClienteDTO;
import com.app.concessionario.entity.Cliente;
import com.app.concessionario.entity.Concessionario;
import com.app.concessionario.mapper.ClienteMapper;
import com.app.concessionario.repositories.ClienteRepository;
import com.app.concessionario.repositories.ConcessionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ConcessionarioRepository concessionarioRepository;

//                                  CHIAMATE DTO

//    chiamata get per tutti i clienti
    public List<ClienteDTO> getClientiDTO() {
        List<ClienteDTO> clientiDTO = new ArrayList<>();
        List<Cliente> clienti = clienteRepository.findAll();
        for (Cliente c : clienti) {
            ClienteDTO clienteDTO = ClienteMapper.toDTO(c);
            clientiDTO.add(clienteDTO);
        }
        return clientiDTO;
    }

//    chiamata get per un singolo cliente
    public ClienteDTO getClienteDTO(Integer id) {
        Optional<Cliente> c = clienteRepository.findById(id);
        return ClienteMapper.toDTO(c.get());
    }

//    chiamata in post per creare un nuovo cliente
//    #### TODO GESTIRE NUOVO CLIENTE CON STESSO ID O LA STESSA MAIL
    public void addClienteDTO(ClienteDTO clienteDTO) {
        List<Concessionario> concessionari = concessionarioRepository.findAll();
        Cliente newCliente = ClienteMapper.toEntity(clienteDTO, concessionari);
        clienteRepository.save(newCliente);
    }

//    chiamata per update cliente
    public void updateClienteDTO(Integer id, ClienteDTO clienteDTO) {
        List<Concessionario> concessionari = concessionarioRepository.findAll();
        Cliente newCliente = ClienteMapper.toEntity(clienteDTO, concessionari);
        newCliente.setId(id);
        clienteRepository.save(newCliente);
    }

//    chiamata per eliminare un cliente
//    #### TODO GESTIRE ID NON ESISTENTE
    public void deleteCliente(Integer id) {
    clienteRepository.deleteById(id);
}

}
