package com.konex.loteria.Sorteo.DTOs;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

/**
 * Objeto de transferencia de datos (DTO) utilizado para recibir la información
 * necesaria al momento de crear o actualizar un sorteo.
 *
 * <p>Incluye validaciones que garantizan la integridad de los datos
 * antes de ser procesados por la capa de servicio.</p>
 */
@Data
public class SorteoRequestDTO {

    /** Nombre del sorteo. No puede estar vacío ni superar los 100 caracteres. */
    @NotBlank(message = "El nombre del sorteo es obligatorio.")
    @Size(max = 100, message = "El nombre del sorteo no puede tener más de 100 caracteres.")
    private String nombre;

    /** Fecha en la que se realizará el sorteo. No puede ser anterior al día actual. */
    @NotNull(message = "La fecha del sorteo es obligatoria.")
    @FutureOrPresent(message = "La fecha del sorteo no puede ser anterior al día actual.")
    private LocalDate fechaSorteo;
}
