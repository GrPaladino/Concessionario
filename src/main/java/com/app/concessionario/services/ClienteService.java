package com.app.concessionario.services;

import com.app.concessionario.dto.ClienteDTO;
import com.app.concessionario.entity.Cliente;
import com.app.concessionario.entity.Concessionario;
import com.app.concessionario.mapper.ClienteMapper;
import com.app.concessionario.repositories.ClienteRepository;
import com.app.concessionario.repositories.ConcessionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public void addClienteDTO(ClienteDTO clienteDTO) throws Exception {
        List<Integer> clientiIds = clienteRepository.findAll().stream().map(Cliente::getId).toList();
        List<String> clientiMails = clienteRepository.findAll().stream().map(Cliente::getEmail).toList();
        if (clientiIds.contains(clienteDTO.getId())) {
            throw new Exception("L'id del cliente inserito non è valido");
        } else if (clientiMails.contains(clienteDTO.getEmail())) {
            throw new Exception("La mail inserita è già presente");
        } else if (clienteDTO.getEmail() == null) {
            throw new Exception("Il campo email non può essere vuoto");
        } else if (clienteDTO.getNome().length() > 30) {
            throw new Exception("Il campo nome non può superare i 30 caratteri");
        } else if (clienteDTO.getCognome().length() > 30) {
            throw new Exception("Il campo cognome non può superare i 30 caratteri");
        } else if (clienteDTO.getEmail().length() > 100) {
            throw new Exception("Il campo email non può superare i 100 caratteri");
        } else if (clienteDTO.getTelefono().length() > 100) {
            throw new Exception("Il campo telefono non può superare i 30 caratteri");
        }

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
    public void deleteCliente(Integer id) throws Exception {
        List<Integer> clientiIds = clienteRepository.findAll().stream().map(Cliente::getId).toList();
        if (!clientiIds.contains(id)) {
            throw new Exception("Cliente selezionato non presente");
        }
    clienteRepository.deleteById(id);
}

}
