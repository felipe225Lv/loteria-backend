package com.konex.loteria.Cliente;

import com.konex.loteria.Cliente.DTOs.ClienteRequestDTO;
import com.konex.loteria.Cliente.DTOs.ClienteResponseDTO;
import java.util.List;

/**
 * Interfaz de servicio que define las operaciones principales
 * para la gestión de clientes dentro del sistema.
 *
 * <p>Su implementación contendrá la lógica de negocio necesaria
 * para manejar los procesos de creación, consulta, actualización y eliminación.</p>
 */
public interface ClienteService {

    /**
     * Obtiene todos los clientes registrados.
     *
     * @return lista de {@link ClienteResponseDTO}
     */
    List<ClienteResponseDTO> getClientes();

    /**
     * Obtiene un cliente por su identificador único.
     *
     * @param id identificador del cliente
     * @return objeto {@link ClienteResponseDTO} si existe
     */
    ClienteResponseDTO get(Long id);

    /**
     * Crea un nuevo cliente en el sistema.
     *
     * @param dto datos del cliente a crear
     * @return cliente creado como {@link ClienteResponseDTO}
     */
    ClienteResponseDTO save(ClienteRequestDTO dto);

    /**
     * Actualiza la información de un cliente existente.
     *
     * @param id identificador del cliente a actualizar
     * @param dto nuevos datos del cliente
     * @return cliente actualizado como {@link ClienteResponseDTO}
     */
    ClienteResponseDTO update(Long id, ClienteRequestDTO dto);

    /**
     * Elimina un cliente del sistema.
     *
     * @param id identificador del cliente a eliminar
     */
    void delete(Long id);
}
