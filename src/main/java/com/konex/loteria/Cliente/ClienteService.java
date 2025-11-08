package com.konex.loteria.Cliente;

import com.konex.loteria.Cliente.DTOs.ClienteRequestDTO;
import com.konex.loteria.Cliente.DTOs.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteResponseDTO> getClientes();

    ClienteResponseDTO get(Long id);

    ClienteResponseDTO save(ClienteRequestDTO dto);

    ClienteResponseDTO update(Long id,ClienteRequestDTO dto);

    void delete(Long id);
}
