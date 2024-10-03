package com.app.concessionario.repositories;

import com.app.concessionario.entity.Concessionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionarioRepository extends JpaRepository<Concessionario, Integer> {}
