package main.java.com.app.concessionario.services;

import main.java.com.app.concessionario.entity.Cliente;
import main.java.com.app.concessionario.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClienti() {
        return clienteRepository.findAll();
    }

    public Cliente getCliente(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public void addCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void updateCliente(Integer id, Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
