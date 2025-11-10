package com.konex.loteria.Sorteo.DTOs;

import lombok.Data;
import java.time.LocalDate;

/**
 * Objeto de transferencia de datos (DTO) utilizado para enviar
 * la información de un sorteo como respuesta al cliente.
 *
 * <p>Contiene los campos principales del sorteo junto con
 * la cantidad total de billetes asociados.</p>
 */
@Data
public class SorteoResponseDTO {

    /** Identificador único del sorteo. */
    private Long id;

    /** Nombre del sorteo. */
    private String nombre;

    /** Fecha en la que se llevará a cabo el sorteo. */
    private LocalDate fechaSorteo;

    /** Número total de billetes asociados al sorteo. */
    private int cantidadBilletes;
}
