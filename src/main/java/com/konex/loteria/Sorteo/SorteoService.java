package com.konex.loteria.Sorteo;

import com.konex.loteria.Sorteo.DTOs.SorteoRequestDTO;
import com.konex.loteria.Sorteo.DTOs.SorteoResponseDTO;
import java.util.List;

/**
 * Interfaz que define los métodos principales del servicio de sorteos.
 *
 * <p>Establece el contrato para las operaciones de negocio relacionadas
 * con la gestión de sorteos dentro del sistema.</p>
 */
public interface SorteoService {

    /**
     * Obtiene todos los sorteos registrados en el sistema.
     *
     * @return Lista de {@link SorteoResponseDTO} con los sorteos existentes.
     */
    List<SorteoResponseDTO> getSorteos();

    /**
     * Obtiene un sorteo específico por su identificador.
     *
     * @param id Identificador único del sorteo.
     * @return Objeto {@link SorteoResponseDTO} con los datos del sorteo.
     */
    SorteoResponseDTO get(Long id);

    /**
     * Registra un nuevo sorteo en el sistema.
     *
     * @param dto DTO con los datos del sorteo a registrar.
     * @return Objeto {@link SorteoResponseDTO} con la información del sorteo creado.
     */
    SorteoResponseDTO save(SorteoRequestDTO dto);

    /**
     * Actualiza los datos de un sorteo existente.
     *
     * @param id Identificador del sorteo a actualizar.
     * @param dto DTO con los nuevos datos del sorteo.
     * @return {@link SorteoResponseDTO} con los datos del sorteo actualizado.
     */
    SorteoResponseDTO update(Long id, SorteoRequestDTO dto);

    /**
     * Elimina un sorteo del sistema.
     *
     * @param id Identificador del sorteo a eliminar.
     */
    void delete(Long id);
}
