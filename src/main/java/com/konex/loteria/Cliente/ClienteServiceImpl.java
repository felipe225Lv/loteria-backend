package com.konex.loteria.Cliente;

import com.konex.loteria.Cliente.DTOs.ClienteRequestDTO;
import com.konex.loteria.Cliente.DTOs.ClienteResponseDTO;
import com.konex.loteria.Exception.InvalidClienteDataException;
import com.konex.loteria.Exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ClienteResponseDTO> getClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteResponseDTO get(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el cliente con el id: " + id));

        return clienteMapper.toResponseDTO(cliente);
    }

    @Override
    @Transactional
    public ClienteResponseDTO save(ClienteRequestDTO dto) {
        Cliente cliente = clienteMapper.toEntity(dto);

        if (!ClienteValidator.isValid(cliente)) {
            throw new InvalidClienteDataException("Los datos del cliente no son correctos. ");
        }

        Cliente saved = clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public ClienteResponseDTO update(Long id, ClienteRequestDTO cliente) {
        Cliente existente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el cliente con id: " + id));

        existente.setNombre(cliente.getNombre());
        existente.setCorreo(cliente.getCorreo());

        if (!ClienteValidator.isValid(existente)) {
            throw new InvalidClienteDataException("Los datos del cliente no son correctos. ");
        }

        Cliente updated = clienteRepository.save(existente);
        return clienteMapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontro el cliente con id: " + id);
        }
        clienteRepository.deleteById(id);
    }
}
