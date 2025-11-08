package com.konex.loteria.Sorteo;

import com.konex.loteria.Sorteo.DTOs.SorteoRequestDTO;
import com.konex.loteria.Sorteo.DTOs.SorteoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SorteoMapper {

    public Sorteo toEntity(SorteoRequestDTO dto) {
        Sorteo sorteo = new Sorteo();
        sorteo.setNombre(dto.getNombre());
        sorteo.setFechaSorteo(dto.getFechaSorteo());
        return sorteo;
    }

    public SorteoResponseDTO toResponseDTO(Sorteo sorteo) {
        SorteoResponseDTO dto = new SorteoResponseDTO();
        dto.setId(sorteo.getId());
        dto.setNombre(sorteo.getNombre());
        dto.setFechaSorteo(sorteo.getFechaSorteo());
        dto.setCantidadBilletes(
                sorteo.getBilletes() != null ? sorteo.getBilletes().size() : 0
        );
        return dto;
    }
}
