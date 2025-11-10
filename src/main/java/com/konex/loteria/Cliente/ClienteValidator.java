package com.konex.loteria.Cliente;

import com.konex.loteria.Exception.InvalidClienteDataException;
import org.springframework.util.StringUtils;

/**
 * Clase utilitaria encargada de validar los datos de un cliente
 * antes de realizar operaciones de persistencia en la base de datos.
 *
 * <p>Verifica que los campos obligatorios cumplan las reglas definidas
 * de formato y longitud, lanzando excepciones personalizadas si no se cumplen.</p>
 */
public class ClienteValidator {

    /**
     * Valida si un cliente tiene datos correctos antes de guardarlo.
     *
     * @param cliente objeto {@link Cliente} a validar
     * @return {@code true} si el cliente es válido
     * @throws InvalidClienteDataException si algún campo no cumple las reglas
     */
    public static boolean isValid(Cliente cliente) {
        if (cliente == null) {
            throw new InvalidClienteDataException("El cliente no puede ser nulo.");
        }

        validateNombre(cliente.getNombre());
        validateCorreo(cliente.getCorreo());

        return true;
    }

    /**
     * Valida el nombre del cliente asegurando que no esté vacío
     * y que no supere el límite de caracteres.
     *
     * @param nombre nombre del cliente
     */
    private static void validateNombre(String nombre) {
        if (!StringUtils.hasText(nombre)) {
            throw new InvalidClienteDataException("El nombre del cliente no puede estar vacío.");
        }
        if (nombre.length() > 100) {
            throw new InvalidClienteDataException("El nombre del cliente no debe superar los 100 caracteres.");
        }
    }

    /**
     * Valida el correo electrónico del cliente comprobando su formato.
     *
     * @param correo correo electrónico a validar
     */
    private static void validateCorreo(String correo) {
        if (!StringUtils.hasText(correo)) {
            throw new InvalidClienteDataException("El correo del cliente no puede estar vacío.");
        }
        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidClienteDataException("El correo electrónico no tiene un formato válido.");
        }
    }
}
