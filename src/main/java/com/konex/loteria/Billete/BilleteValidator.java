package com.konex.loteria.Billete;

import java.math.BigDecimal;

/**
 * Clase utilitaria para validar los datos de un {@link Billete} antes de persistirlo o actualizarlo.
 *
 * <p>Permite asegurar la integridad de los datos a nivel de negocio antes de
 * llegar a la base de datos.</p>
 */
public class BilleteValidator {

    /** Longitud máxima permitida para el número de billete. */
    private static final int NUMERO_MAX_LENGTH = 10;

    /**
     * Válida que el número del billete sea no nulo, no vacío y tenga una longitud válida.
     *
     * @param numero número del billete
     * @return true si es válido, false en caso contrario
     */
    public static boolean isValidNumero(String numero) {
        return numero != null && !numero.trim().isEmpty() && numero.length() <= NUMERO_MAX_LENGTH;
    }

    /**
     * Válida que el precio del billete sea un valor positivo.
     *
     * @param precio precio del billete
     * @return true si es válido, false en caso contrario
     */
    public static boolean isValidPrecio(BigDecimal precio) {
        return precio != null && precio.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * Válida que el estado del billete sea válido.
     *
     * @param estado estado del billete
     * @return true si es válido, false en caso contrario
     */
    public static boolean isValidEstado(EstadoBillete estado) {
        return estado != null;
    }

    /**
     * Válida el objeto {@link Billete} completo verificando sus atributos esenciales.
     *
     * @param billete billete a validar
     * @return true si todos los campos son válidos, false en caso contrario
     */
    public static boolean isValid(Billete billete) {
        return billete != null &&
                isValidNumero(billete.getNumero()) &&
                isValidPrecio(billete.getPrecio()) &&
                isValidEstado(billete.getEstado()) &&
                billete.getSorteo() != null; // El sorteo siempre debe existir
    }
}
