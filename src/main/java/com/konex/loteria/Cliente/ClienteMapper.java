package com.konex.loteria.Cliente;

import com.konex.loteria.Cliente.DTOs.ClienteRequestDTO;
import com.konex.loteria.Cliente.DTOs.ClienteResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Clase encargada de mapear entre las entidades del dominio {@link Cliente}
 * y sus correspondientes DTOs de solicitud y respuesta.
 *
 * <p>Su objetivo es mantener una separación clara entre la capa de persistencia
 * y la capa de transporte de datos (API REST).</p>
 */
@Component
public class ClienteMapper {

    /**
     * Convierte un objeto {@link ClienteRequestDTO} en una entidad {@link Cliente}.
     *
     * @param dto datos del cliente provenientes de una solicitud
     * @return entidad {@link Cliente} lista para persistir
     */
    public Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        return cliente;
    }

    /**
     * Convierte una entidad {@link Cliente} en un objeto {@link ClienteResponseDTO}.
     *
     * @param cliente entidad cliente obtenida desde la base de datos
     * @return DTO de respuesta con los datos del cliente
     */
    public ClienteResponseDTO toResponseDTO(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getCorreo()
        );
    }
}
