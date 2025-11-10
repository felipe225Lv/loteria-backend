package com.konex.loteria.Sorteo;

import com.konex.loteria.Sorteo.DTOs.SorteoRequestDTO;
import com.konex.loteria.Sorteo.DTOs.SorteoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST encargado de gestionar las operaciones CRUD
 * relacionadas con la entidad {@link Sorteo}.
 *
 * <p>Expone los endpoints para registrar, consultar, actualizar y eliminar sorteos,
 * siguiendo el estándar REST.</p>
 *
 * <p>Ruta base: <b>/loteria/sorteos</b></p>
 */
@RestController
@RequestMapping("/loteria/sorteos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SorteoController {

    /** Servicio que contiene la lógica de negocio para la gestión de sorteos. */
    private final SorteoService sorteoService;

    /**
     * Crea un nuevo sorteo en el sistema.
     *
     * @param requestDTO datos del sorteo a registrar
     * @return respuesta con el sorteo creado y código HTTP 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<SorteoResponseDTO> save(@Valid @RequestBody SorteoRequestDTO requestDTO) {
        SorteoResponseDTO responseDTO = sorteoService.save(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    /**
     * Obtiene la lista completa de sorteos registrados.
     *
     * @return lista de sorteos y código HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<SorteoResponseDTO>> getAll() {
        List<SorteoResponseDTO> sorteos = sorteoService.getSorteos();
        return ResponseEntity.ok(sorteos);
    }

    /**
     * Obtiene un sorteo específico por su identificador único.
     *
     * @param id identificador del sorteo
     * @return sorteo encontrado y código HTTP 200 (OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<SorteoResponseDTO> get(@PathVariable Long id) {
        SorteoResponseDTO sorteo = sorteoService.get(id);
        return ResponseEntity.ok(sorteo);
    }

    /**
     * Actualiza los datos de un sorteo existente.
     *
     * @param id identificador del sorteo a actualizar
     * @param requestDTO nuevos datos del sorteo
     * @return sorteo actualizado y código HTTP 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<SorteoResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody SorteoRequestDTO requestDTO) {
        SorteoResponseDTO actualizado = sorteoService.update(id, requestDTO);
        return ResponseEntity.ok(actualizado);
    }

    /**
     * Elimina un sorteo del sistema.
     *
     * @param id identificador del sorteo a eliminar
     * @return respuesta sin contenido y código HTTP 204 (NO CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sorteoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
