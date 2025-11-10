package com.konex.loteria.Sorteo;

import com.konex.loteria.Exception.InvalidSorteoDataException;
import org.springframework.util.StringUtils;
import java.time.LocalDate;

/**
 * Clase utilitaria para validar los datos de un objeto {@link Sorteo}
 * antes de su persistencia en la base de datos.
 *
 * <p>Evita que se almacenen sorteos con información inconsistente
 * o con datos no válidos.</p>
 */
public class SorteoValidator {

    /**
     * Valida un objeto {@link Sorteo} completo.
     *
     * @param sorteo Objeto a validar.
     * @return true si los datos son válidos.
     * @throws InvalidSorteoDataException si algún dato no cumple las reglas de validación.
     */
    public static boolean isValid(Sorteo sorteo) {
        if (!isValidNombre(sorteo.getNombre())) {
            throw new InvalidSorteoDataException("El nombre del sorteo es inválido.");
        }

        if (!isValidFecha(sorteo.getFechaSorteo())) {
            throw new InvalidSorteoDataException("La fecha del sorteo es inválida o está en el pasado.");
        }

        return false;
    }

    /**
     * Valida el nombre del sorteo.
     *
     * @param nombre Nombre del sorteo.
     * @return true si es válido (no vacío y máximo 100 caracteres).
     */
    private static boolean isValidNombre(String nombre) {
        return StringUtils.hasText(nombre) && nombre.length() <= 100;
    }

    /**
     * Valida que la fecha del sorteo no sea nula ni anterior al día actual.
     *
     * @param fecha Fecha del sorteo.
     * @return true si la fecha es válida.
     */
    private static boolean isValidFecha(LocalDate fecha) {
        return fecha != null && !fecha.isBefore(LocalDate.now());
    }
}
