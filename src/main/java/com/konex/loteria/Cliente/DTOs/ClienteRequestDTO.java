package com.konex.loteria.Cliente.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO utilizado para recibir los datos necesarios al crear o actualizar
 * un cliente dentro del sistema de lotería.
 *
 * <p>Incluye validaciones básicas para garantizar que la información
 * ingresada sea correcta antes de ser procesada por el backend.</p>
 */
@Data
public class ClienteRequestDTO {

    /**
     * Nombre completo del cliente.
     * <p>Debe contener entre 2 y 100 caracteres.</p>
     */
    @NotBlank(message = "El nombre del cliente es obligatorio.")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres.")
    private String nombre;

    /**
     * Correo electrónico del cliente.
     * <p>Debe ser un formato válido y no puede estar vacío.</p>
     */
    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Email(message = "Debe ingresar un correo electrónico válido.")
    private String correo;
}
