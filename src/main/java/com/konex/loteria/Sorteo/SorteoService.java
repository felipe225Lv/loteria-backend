package com.konex.loteria.Sorteo;


import com.konex.loteria.Sorteo.DTOs.SorteoRequestDTO;
import com.konex.loteria.Sorteo.DTOs.SorteoResponseDTO;

import java.util.List;

public interface SorteoService {

    List<SorteoResponseDTO> getSorteos();

    SorteoResponseDTO get(Long id);

    SorteoResponseDTO save(SorteoRequestDTO dto);

    SorteoResponseDTO update(Long id,SorteoRequestDTO dto);

    void delete(Long id);
}
