package com.konex.loteria.Sorteo;

import com.konex.loteria.Billete.Billete;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un sorteo dentro del sistema de lotería.
 *
 * <p>Contiene los datos principales del sorteo, como su nombre, fecha,
 * y la relación con los billetes participantes.</p>
 */
@Entity
@Data
public class Sorteo {

    /** Identificador único del sorteo, generado automáticamente. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre descriptivo del sorteo. */
    private String nombre;

    /** Fecha programada para la realización del sorteo. */
    private LocalDate fechaSorteo;

    /**
     * Relación uno a muchos con la entidad {@link Billete}.
     * <p>Cada sorteo puede tener múltiples billetes asociados.
     * Si un sorteo es eliminado, sus billetes se eliminan automáticamente.</p>
     */
    @OneToMany(mappedBy = "sorteo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Billete> billetes = new ArrayList<>();
}
