package com.konex.loteria.Sorteo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para gestionar operaciones CRUD sobre la entidad {@link Sorteo}.
 */
@Repository
public interface SorteoRepository extends JpaRepository<Sorteo, Long> {
}
