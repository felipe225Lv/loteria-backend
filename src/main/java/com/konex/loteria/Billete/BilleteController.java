package com.konex.loteria.Billete;

import com.konex.loteria.Billete.DTOs.BilleteRequestDTO;
import com.konex.loteria.Billete.DTOs.BilleteResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST encargado de gestionar las operaciones CRUD
 * relacionadas con la entidad {@link Billete}.
 *
 * <p>Expone endpoints para crear, consultar, actualizar y eliminar billetes,
 * aplicando el estándar REST y devolviendo respuestas adecuadas según el caso.</p>
 *
 * <p>Ruta base: <b>/loteria/billetes</b></p>
 */
@RestController
@RequestMapping("/loteria/billetes")
@RequiredArgsConstructor
public class BilleteController {

    /** Servicio que contiene la lógica de negocio para la gestión de billetes. */
    private final BilleteService billeteService;

    /**
     * Crea un nuevo billete a partir de los datos enviados en el cuerpo de la solicitud.
     *
     * @param requestDTO datos del billete a registrar
     * @return respuesta con el billete creado y código HTTP 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<BilleteResponseDTO> save(@Valid @RequestBody BilleteRequestDTO requestDTO) {
        BilleteResponseDTO responseDTO = billeteService.save(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    /**
     * Obtiene la lista completa de billetes registrados en el sistema.
     *
     * @return lista de billetes y código HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<BilleteResponseDTO>> getAll() {
        List<BilleteResponseDTO> billetes = billeteService.getBilletes();
        return ResponseEntity.ok(billetes);
    }

    /**
     * Obtiene un billete específico por su identificador único.
     *
     * @param id identificador del billete a consultar
     * @return billete encontrado y código HTTP 200 (OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<BilleteResponseDTO> get(@PathVariable Long id) {
        BilleteResponseDTO billete = billeteService.get(id);
        return ResponseEntity.ok(billete);
    }

    /**
     * Actualiza los datos de un billete existente.
     *
     * @param id identificador del billete a actualizar
     * @param requestDTO nuevos datos para el billete
     * @return billete actualizado y código HTTP 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<BilleteResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody BilleteRequestDTO requestDTO) {
        BilleteResponseDTO actualizado = billeteService.update(id, requestDTO);
        return ResponseEntity.ok(actualizado);
    }

    /**
     * Elimina un billete del sistema según su identificador.
     *
     * @param id identificador del billete a eliminar
     * @return respuesta sin contenido y código HTTP 204 (NO CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        billeteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
