package com.konex.loteria.Cliente;

import com.konex.loteria.Cliente.DTOs.ClienteRequestDTO;
import com.konex.loteria.Cliente.DTOs.ClienteResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        return cliente;
    }

    public ClienteResponseDTO toResponseDTO(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getCorreo()
        );
    }
}
