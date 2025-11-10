package com.konex.loteria.Cliente.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO utilizado para enviar información de un cliente como respuesta
 * a las solicitudes del cliente (API REST).
 *
 * <p>Contiene los datos básicos que identifican a un cliente
 * dentro del sistema de lotería.</p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    /** Identificador único del cliente. */
    private Long id;

    /** Nombre completo del cliente. */
    private String nombre;

    /** Correo electrónico del cliente. */
    private String correo;
}
