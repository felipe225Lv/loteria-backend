package com.konex.loteria.Billete;

import com.konex.loteria.Cliente.Cliente;
import com.konex.loteria.Sorteo.Sorteo;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

/**
 * Entidad que representa un billete dentro de un sorteo.
 * Cada billete puede estar asociado a un cliente (si fue vendido)
 * y pertenece a un sorteo específico.
 */
@Entity
@Data
public class Billete {

    /** Identificador único generado automáticamente para cada billete. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número del billete dentro del sorteo. */
    private String numero;

    /** Precio de venta del billete. */
    private BigDecimal precio;

    /**
     * Estado actual del billete.
     * El valor por defecto es DISPONIBLE.
     */
    @Enumerated(EnumType.STRING)
    private EstadoBillete estado = EstadoBillete.DISPONIBLE;

    /** Sorteo al que pertenece este billete. */
    @ManyToOne
    @JoinColumn(name = "sorteo_id")
    private Sorteo sorteo;

    /** Cliente que adquirió el billete (opcional si aún no ha sido vendido). */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
