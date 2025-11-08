package com.konex.loteria.Sorteo;

import com.konex.loteria.Exception.InvalidSorteoDataException;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class SorteoValidator {

    public static boolean isValid(Sorteo sorteo) {
        if (!isValidNombre(sorteo.getNombre())) {
            throw new InvalidSorteoDataException("El nombre del sorteo es inválido.");
        }

        if (!isValidFecha(sorteo.getFechaSorteo())) {
            throw new InvalidSorteoDataException("La fecha del sorteo es inválida o está en el pasado.");
        }

        return true;
    }

    private static boolean isValidNombre(String nombre) {
        return StringUtils.hasText(nombre) && nombre.length() <= 100;
    }

    private static boolean isValidFecha(LocalDate fecha) {
        return fecha != null && !fecha.isBefore(LocalDate.now());
    }
}
