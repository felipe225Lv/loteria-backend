package com.konex.loteria.Billete;

import com.konex.loteria.Billete.DTOs.BilleteRequestDTO;
import com.konex.loteria.Billete.DTOs.BilleteResponseDTO;
import com.konex.loteria.Cliente.Cliente;
import com.konex.loteria.Cliente.ClienteRepository;
import com.konex.loteria.Exception.InvalidBilleteDataException;
import com.konex.loteria.Exception.ResourceNotFoundException;
import com.konex.loteria.Sorteo.Sorteo;
import com.konex.loteria.Sorteo.SorteoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de gestión de billetes.
 *
 * Proporciona la lógica de negocio para crear, consultar, actualizar y eliminar billetes.
 * Integra validaciones, manejo de excepciones y conversión entre entidades y DTOs.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BilleteServiceImpl implements BilleteService {

    private final BilleteRepository billeteRepository;
    private final ClienteRepository clienteRepository;
    private final SorteoRepository sorteoRepository;
    private final BilleteMapper billeteMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<BilleteResponseDTO> getBilletes() {
        return billeteRepository.findAll()
                .stream()
                .map(billeteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public BilleteResponseDTO get(Long id) {
        Billete billete = billeteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Billete no encontrado con el id: " + id));

        return billeteMapper.toResponseDTO(billete);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public BilleteResponseDTO save(BilleteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con el id: " + dto.getClienteId()));

        Sorteo sorteo = sorteoRepository.findById(dto.getSorteoId())
                .orElseThrow(() -> new ResourceNotFoundException("Sorteo no encontrado con el id: " + dto.getSorteoId()));


        Billete billete = billeteMapper.toEntity(dto, sorteo, cliente);

        if (!BilleteValidator.isValid(billete)) {
            throw new InvalidBilleteDataException("Los datos del billete no son correctos.");
        }

        if (billete.getEstado() == null) {
            billete.setEstado(EstadoBillete.DISPONIBLE);
        }

        Billete saved = billeteRepository.save(billete);
        return billeteMapper.toResponseDTO(saved);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public BilleteResponseDTO update(Long id, BilleteRequestDTO dto) {
        Billete existente = billeteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Billete no encontrado con el id: " + id));

        // Actualizamos los campos relevantes
        existente.setNumero(dto.getNumero() != null ? dto.getNumero() : existente.getNumero());
        existente.setPrecio(dto.getPrecio());
        existente.setEstado(EstadoBillete.valueOf(dto.getEstado()));

        if (!BilleteValidator.isValid(existente)) {
            throw new InvalidBilleteDataException("Los datos del billete no son correctos.");
        }

        Billete updated = billeteRepository.save(existente);
        return billeteMapper.toResponseDTO(updated);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(Long id) {
        if (!billeteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Billete no encontrado con el id: " + id);
        }
        billeteRepository.deleteById(id);
    }
}
