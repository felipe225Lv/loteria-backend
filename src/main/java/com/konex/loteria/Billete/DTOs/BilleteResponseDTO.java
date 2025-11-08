package com.konex.loteria.Billete.DTOs;

import lombok.Data;
import java.math.BigDecimal;

/**
 * DTO utilizado para enviar información del billete al cliente.
 * Incluye datos básicos del billete, junto con información del sorteo y del cliente asociado.
 */
@Data
public class BilleteResponseDTO {

    /** Identificador único del billete. */
    private Long id;

    /** Número que identifica el billete dentro del sorteo. */
    private String numero;

    /** Precio del billete. */
    private BigDecimal precio;

    /** Estado actual del billete. */
    private String estado;

    /** Identificador del sorteo al que pertenece el billete. */
    private Long sorteoId;

    /** Nombre del sorteo (informativo). */
    private String sorteoNombre;

    /** Identificador del cliente asociado al billete. */
    private Long clienteId;

    /** Nombre del cliente que adquirió el billete. */
    private String clienteNombre;
}
