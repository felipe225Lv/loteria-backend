package com.konex.loteria.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para gestionar operaciones CRUD sobre la entidad {@link Cliente}.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
