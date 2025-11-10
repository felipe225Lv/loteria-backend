package com.konex.loteria.Cliente;

import com.konex.loteria.Cliente.DTOs.ClienteRequestDTO;
import com.konex.loteria.Cliente.DTOs.ClienteResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST encargado de gestionar las operaciones CRUD
 * relacionadas con la entidad {@link Cliente}.
 *
 * <p>Expone los endpoints necesarios para registrar, consultar,
 * actualizar y eliminar clientes dentro del sistema de lotería.</p>
 *
 * <p>Ruta base: <b>/loteria/clientes</b></p>
 */
@RestController
@RequestMapping("/loteria/clientes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClienteController {

    /** Servicio que contiene la lógica de negocio para la gestión de clientes. */
    private final ClienteService clienteService;

    /**
     * Crea un nuevo cliente en el sistema.
     *
     * @param requestDTO datos del cliente a registrar
     * @return respuesta con el cliente creado y código HTTP 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> save(@Valid @RequestBody ClienteRequestDTO requestDTO) {
        ClienteResponseDTO responseDTO = clienteService.save(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    /**
     * Obtiene la lista completa de clientes registrados.
     *
     * @return lista de clientes y código HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAll() {
        List<ClienteResponseDTO> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    /**
     * Obtiene un cliente específico por su identificador único.
     *
     * @param id identificador del cliente
     * @return cliente encontrado y código HTTP 200 (OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> get(@PathVariable Long id) {
        ClienteResponseDTO cliente = clienteService.get(id);
        return ResponseEntity.ok(cliente);
    }

    /**
     * Actualiza los datos de un cliente existente.
     *
     * @param id identificador del cliente a actualizar
     * @param requestDTO nuevos datos del cliente
     * @return cliente actualizado y código HTTP 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ClienteRequestDTO requestDTO) {
        ClienteResponseDTO actualizado = clienteService.update(id, requestDTO);
        return ResponseEntity.ok(actualizado);
    }

    /**
     * Elimina un cliente del sistema.
     *
     * @param id identificador del cliente a eliminar
     * @return respuesta sin contenido y código HTTP 204 (NO CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
