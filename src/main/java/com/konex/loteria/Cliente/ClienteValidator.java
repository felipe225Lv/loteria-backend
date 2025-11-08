package com.konex.loteria.Cliente;

import com.konex.loteria.Exception.InvalidClienteDataException;
import org.springframework.util.StringUtils;

public class ClienteValidator {

    /**
     * Valida si un cliente tiene datos correctos antes de guardarlo.
     *
     * @param cliente Objeto Cliente a validar
     * @return true si es válido
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

    private static void validateNombre(String nombre) {
        if (!StringUtils.hasText(nombre)) {
            throw new InvalidClienteDataException("El nombre del cliente no puede estar vacío.");
        }
        if (nombre.length() > 100) {
            throw new InvalidClienteDataException("El nombre del cliente no debe superar los 100 caracteres.");
        }
    }

    private static void validateCorreo(String correo) {
        if (!StringUtils.hasText(correo)) {
            throw new InvalidClienteDataException("El correo del cliente no puede estar vacío.");
        }
        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidClienteDataException("El correo electrónico no tiene un formato válido.");
        }
    }
}
