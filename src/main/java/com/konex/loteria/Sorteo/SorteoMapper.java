package com.konex.loteria.Sorteo;

import com.konex.loteria.Sorteo.DTOs.SorteoRequestDTO;
import com.konex.loteria.Sorteo.DTOs.SorteoResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Clase encargada de realizar la conversión entre entidades {@link Sorteo}
 * y sus respectivos DTOs ({@link SorteoRequestDTO} y {@link SorteoResponseDTO}).
 *
 * <p>Permite desacoplar la lógica de transformación de datos entre las capas
 * del sistema (controlador, servicio y persistencia).</p>
 */
@Component
public class SorteoMapper {

    /**
     * Convierte un objeto {@link SorteoRequestDTO} en una entidad {@link Sorteo}.
     *
     * @param dto DTO con los datos del sorteo a registrar o actualizar.
     * @return Entidad {@link Sorteo} lista para ser persistida.
     */
    public Sorteo toEntity(SorteoRequestDTO dto) {
        Sorteo sorteo = new Sorteo();
        sorteo.setNombre(dto.getNombre());
        sorteo.setFechaSorteo(dto.getFechaSorteo());
        return sorteo;
    }

    /**
     * Convierte una entidad {@link Sorteo} en un objeto {@link SorteoResponseDTO}
     * que será devuelto al cliente.
     *
     * @param sorteo Entidad {@link Sorteo} obtenida desde la base de datos.
     * @return DTO con la información del sorteo y la cantidad de billetes asociados.
     */
    public SorteoResponseDTO toResponseDTO(Sorteo sorteo) {
        SorteoResponseDTO dto = new SorteoResponseDTO();
        dto.setId(sorteo.getId());
        dto.setNombre(sorteo.getNombre());
        dto.setFechaSorteo(sorteo.getFechaSorteo());
        dto.setCantidadBilletes(
                sorteo.getBilletes() != null ? sorteo.getBilletes().size() : 0
        );
        return dto;
    }
}
