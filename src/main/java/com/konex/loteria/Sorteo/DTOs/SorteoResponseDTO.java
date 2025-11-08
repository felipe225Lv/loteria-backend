package com.konex.loteria.Sorteo.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SorteoResponseDTO {

    private Long id;
    private String nombre;
    private LocalDate fechaSorteo;
    private int cantidadBilletes;
}
