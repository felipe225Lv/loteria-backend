package com.konex.loteria.Billete.DTOs;

import lombok.Data;
import java.math.BigDecimal;

/**
 * DTO utilizado para recibir los datos necesarios al crear o actualizar un billete.
 * Contiene únicamente los atributos requeridos desde el cliente hacia la API.
 */
@Data
public class BilleteRequestDTO {

    /** Número único que identifica el billete dentro de un sorteo. */
    private String numero;

    /** Precio asignado al billete. */
    private BigDecimal precio;

    /** Estado actual del billete (por ejemplo: DISPONIBLE, VENDIDO, ANULADO). */
    private String estado;

    /** Identificador del sorteo al que pertenece el billete. */
    private Long sorteoId;

    /** Identificador del cliente que adquirió el billete, si aplica. */
    private Long clienteId;
}
