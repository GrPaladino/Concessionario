package main.java.com.app.concessionario.repositories;

import main.java.com.app.concessionario.entity.Motore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoreRepository extends JpaRepository<Motore, Integer> {
}
