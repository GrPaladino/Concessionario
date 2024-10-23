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
    public List<ClienteDTO> getClientiDTO() throws Exception {
        List<ClienteDTO> clientiDTO = new ArrayList<>();
        List<Cliente> clienti = clienteRepository.findAll();
        for (Cliente c : clienti) {
            ClienteDTO clienteDTO = ClienteMapper.toDTO(c);
            clientiDTO.add(clienteDTO);
        }
        if (clientiDTO.isEmpty())
            throw new Exception("Nessun cliente presente");
        return clientiDTO;
    }

    //    chiamata get per un singolo cliente
    public ClienteDTO getClienteDTO(Integer id) throws Exception {
        Optional<Cliente> c = clienteRepository.findById(id);
        if (!c.isPresent())
            throw new Exception("L'id inserito non è corretto");

        return ClienteMapper.toDTO(c.get());
    }

    //    chiamata in post per creare un nuovo cliente
    public void addClienteDTO(ClienteDTO clienteDTO) throws Exception {
        Optional<Cliente> c = clienteRepository.findById(clienteDTO.getId());
        String mail = c.get().getEmail();

        if (c.isPresent())
            throw new Exception("L'id del cliente inserito non è valido");

        if (clienteDTO.getEmail() == null)
            throw new Exception("Il campo email non può essere vuoto");

        if (clienteDTO.getEmail().equalsIgnoreCase(mail))
            throw new Exception("La mail inserita è già presente");

        if (clienteDTO.getNome().length() > 30)
            throw new Exception("Il campo nome non può superare i 30 caratteri");

        if (clienteDTO.getCognome().length() > 30)
            throw new Exception("Il campo cognome non può superare i 30 caratteri");

        if (clienteDTO.getEmail().length() > 100)
            throw new Exception("Il campo email non può superare i 100 caratteri");

        if (clienteDTO.getTelefono().length() > 100)
            throw new Exception("Il campo telefono non può superare i 30 caratteri");

        List<Concessionario> concessionari = concessionarioRepository.findAll();
        Cliente newCliente = ClienteMapper.toEntity(clienteDTO, concessionari);
        clienteRepository.save(newCliente);
    }

    //    chiamata per update cliente
    public void updateClienteDTO(Integer id, ClienteDTO clienteDTO) throws Exception {
        Optional<Cliente> c = clienteRepository.findById(id);

        if (c.isPresent()) {
            String mail = c.get().getEmail();

            if (clienteDTO.getEmail() == null)
                throw new Exception("Il campo email non può essere vuoto");

            if (clienteDTO.getEmail().equalsIgnoreCase(mail))
                throw new Exception("La mail inserita è già presente");

            if (clienteDTO.getNome().length() > 30)
                throw new Exception("Il campo nome non può superare i 30 caratteri");

            if (clienteDTO.getCognome().length() > 30)
                throw new Exception("Il campo cognome non può superare i 30 caratteri");

            if (clienteDTO.getEmail().length() > 100)
                throw new Exception("Il campo email non può superare i 100 caratteri");

            if (clienteDTO.getTelefono().length() > 100)
                throw new Exception("Il campo telefono non può superare i 30 caratteri");

            List<Concessionario> concessionari = concessionarioRepository.findAll();
            Cliente newCliente = ClienteMapper.toEntity(clienteDTO, concessionari);
            newCliente.setId(id);
            clienteRepository.save(newCliente);
        } else {
            throw new Exception("L'id inserito non è valido");
        }
    }

//    chiamata per patch cliente
    public void patchClienteDTO(Integer id, ClienteDTO patchClienteDTO) throws Exception {
        Optional<Cliente> c = clienteRepository.findById(id);

        if (c.isPresent()) {
            String mail = c.get().getEmail();

            if (patchClienteDTO.getEmail() != null) {
                if (patchClienteDTO.getEmail().equalsIgnoreCase(mail))
                    throw new Exception("La mail inserita è già presente");

                if (patchClienteDTO.getEmail().length() > 100)
                    throw new Exception("Il campo email non può superare i 100 caratteri");

                c.get().setEmail(patchClienteDTO.getEmail());
            }

            if (patchClienteDTO.getNome() != null) {
                if (patchClienteDTO.getNome().length() > 30)
                    throw new Exception("Il campo nome non può superare i 30 caratteri");

                c.get().setNome(patchClienteDTO.getNome());
            }

            if (patchClienteDTO.getCognome() != null) {
                if (patchClienteDTO.getCognome().length() > 30)
                    throw new Exception("Il campo cognome non può superare i 30 caratteri");

                c.get().setCognome(patchClienteDTO.getCognome());
            }


            if (patchClienteDTO.getTelefono() != null) {
                if (patchClienteDTO.getTelefono().length() > 100)
                    throw new Exception("Il campo telefono non può superare i 30 caratteri");

                c.get().setTelefono(patchClienteDTO.getTelefono());
            }

            if (patchClienteDTO.getConcessionarioId() != null) {
                List<Concessionario> concessionari = concessionarioRepository.findAll();

                for (Concessionario cli : concessionari) {
                    if (cli.getId().equals(patchClienteDTO.getConcessionarioId()))
                        c.get().setConcessionario(cli);
                }
            }

            c.get().setId(id);
            clienteRepository.save(c.get());
        } else {
            throw new Exception("L'id inserito non è valido");
        }
    }

//    chiamata per eliminare un cliente
        public void deleteCliente (Integer id) throws Exception {
            Optional<Cliente> c = clienteRepository.findById(id);

            if (!c.isPresent()) {
                throw new Exception("Cliente selezionato non presente");
            }
            clienteRepository.deleteById(id);
        }

    }

