package com.konex.loteria.Sorteo.DTOs;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SorteoRequestDTO {

    @NotBlank(message = "El nombre del sorteo es obligatorio.")
    @Size(max = 100, message = "El nombre del sorteo no puede tener más de 100 caracteres.")
    private String nombre;

    @NotNull(message = "La fecha del sorteo es obligatoria.")
    @FutureOrPresent(message = "La fecha del sorteo no puede ser anterior al día actual.")
    private LocalDate fechaSorteo;
}
