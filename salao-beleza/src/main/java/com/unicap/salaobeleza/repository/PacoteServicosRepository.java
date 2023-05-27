package com.unicap.salaobeleza.repository;

import com.unicap.salaobeleza.model.PacoteServicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteServicosRepository extends JpaRepository<PacoteServicos, Long> {
}
