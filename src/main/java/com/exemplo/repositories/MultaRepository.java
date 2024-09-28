package com.exemplo.repositories;

import com.exemplo.models.Multa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultaRepository extends JpaRepository<Multa, Long> {
}

