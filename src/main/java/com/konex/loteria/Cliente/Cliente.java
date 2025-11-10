package com.konex.loteria.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entidad que representa a un cliente dentro de la base de datos del sistema de lotería.
 *
 * <p>Esta clase se mapea directamente a una tabla en la base de datos mediante JPA,
 * permitiendo la persistencia de los datos de los clientes.</p>
 */
@Entity
@Data
public class Cliente {

    /** Identificador único del cliente en la base de datos (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre completo del cliente. */
    private String nombre;

    /** Correo electrónico del cliente. */
    private String correo;
}
