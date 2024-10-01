package main.java.com.app.concessionario.repositories;

import main.java.com.app.concessionario.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {}
