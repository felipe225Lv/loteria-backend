package com.konex.loteria.Sorteo;

import com.konex.loteria.Exception.InvalidSorteoDataException;
import com.konex.loteria.Exception.ResourceNotFoundException;
import com.konex.loteria.Sorteo.DTOs.SorteoRequestDTO;
import com.konex.loteria.Sorteo.DTOs.SorteoResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de gestión de sorteos.
 *
 * Proporciona la lógica de negocio para crear, consultar, actualizar y eliminar sorteos.
 * Integra validaciones, manejo de excepciones y conversión entre entidades y DTOs.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class SorteoServiceImpl implements SorteoService{

    private final SorteoRepository sorteoRepository;
    private final SorteoMapper sorteoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<SorteoResponseDTO> getSorteos() {
        return sorteoRepository.findAll()
                .stream()
                .map(sorteoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public SorteoResponseDTO get(Long id) {
        Sorteo sorteo = sorteoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el sorteo con id: " + id));

        return sorteoMapper.toResponseDTO(sorteo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SorteoResponseDTO save(SorteoRequestDTO dto) {
        Sorteo sorteo = sorteoMapper.toEntity(dto);

        if (SorteoValidator.isValid(sorteo)) {
            throw new InvalidSorteoDataException("Los datos del sorteo no son validos");
        }

        Sorteo saved = sorteoRepository.save(sorteo);
        return sorteoMapper.toResponseDTO(saved);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public SorteoResponseDTO update(Long id, SorteoRequestDTO dto) {
        Sorteo existente = sorteoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el sorteo con id: " + id));

        existente.setNombre(dto.getNombre());
        existente.setFechaSorteo(dto.getFechaSorteo());

        if (SorteoValidator.isValid(existente)) {
            throw new InvalidSorteoDataException("Los datos del sorteo no son validos");
        }

        Sorteo updated = sorteoRepository.save(existente);
        return sorteoMapper.toResponseDTO(updated);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(Long id) {
        if (!sorteoRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontro el sorteo con id: " + id);
        }
        sorteoRepository.deleteById(id);
    }
}
