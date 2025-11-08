package com.konex.loteria.Billete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio JPA para gestionar operaciones CRUD sobre la entidad {@link Billete}.
 * Permite realizar consultas personalizadas según cliente o sorteo.
 */
@Repository
public interface BilleteRepository extends JpaRepository<Billete, Long> {

    /**
     * Busca todos los billetes asociados a un cliente específico.
     *
     * @param clienteId identificador del cliente
     * @return lista de billetes comprados por el cliente
     */
    List<Billete> findByClienteId(Long clienteId);

    /**
     * Busca todos los billetes pertenecientes a un sorteo y que tengan un estado específico.
     *
     * @param sorteoId identificador del sorteo
     * @param estado estado del billete (por ejemplo: DISPONIBLE, VENDIDO)
     * @return lista de billetes que cumplen las condiciones
     */
    List<Billete> findBySorteoIdAndEstado(Long sorteoId, EstadoBillete estado);
}
