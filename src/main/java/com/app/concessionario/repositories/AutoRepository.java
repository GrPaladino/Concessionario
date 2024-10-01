package main.java.com.app.concessionario.repositories;

import main.java.com.app.concessionario.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Integer> {}
