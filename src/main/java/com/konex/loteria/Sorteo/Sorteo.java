package com.konex.loteria.Sorteo;

import com.konex.loteria.Billete.Billete;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Sorteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaSorteo;

    @OneToMany(mappedBy = "sorteo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Billete> billetes = new ArrayList<>();
}
