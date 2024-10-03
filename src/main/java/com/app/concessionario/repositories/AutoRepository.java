package com.app.concessionario.repositories;

import com.app.concessionario.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Integer> {}
