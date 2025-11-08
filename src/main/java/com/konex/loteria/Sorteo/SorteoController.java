package com.konex.loteria.Sorteo;

import com.konex.loteria.Sorteo.DTOs.SorteoRequestDTO;
import com.konex.loteria.Sorteo.DTOs.SorteoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loteria/sorteos")
@RequiredArgsConstructor
public class SorteoController {
    
    private final SorteoService sorteoService;

    @PostMapping
    public ResponseEntity<SorteoResponseDTO> save(@Valid @RequestBody SorteoRequestDTO requestDTO) {
        SorteoResponseDTO responseDTO = sorteoService.save(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<SorteoResponseDTO>> getAll() {
        List<SorteoResponseDTO> clientes = sorteoService.getSorteos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SorteoResponseDTO> get(@PathVariable Long id) {
        SorteoResponseDTO cliente = sorteoService.get(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SorteoResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody SorteoRequestDTO requestDTO) {
        SorteoResponseDTO actualizado = sorteoService.update(id, requestDTO);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sorteoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
