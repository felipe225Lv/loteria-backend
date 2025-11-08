package com.konex.loteria.Billete;

import com.konex.loteria.Billete.DTOs.BilleteRequestDTO;
import com.konex.loteria.Billete.DTOs.BilleteResponseDTO;
import com.konex.loteria.Cliente.Cliente;
import com.konex.loteria.Sorteo.Sorteo;
import org.springframework.stereotype.Component;

/**
 * Componente encargado de mapear objetos entre las entidades {@link Billete}
 * y sus respectivos DTOs de solicitud y respuesta.
 *
 * <p>Su función principal es desacoplar la capa de persistencia de la capa de presentación.</p>
 */
@Component
public class BilleteMapper {

    /**
     * Convierte un objeto {@link BilleteRequestDTO} a una entidad {@link Billete}.
     *
     * @param dto objeto con los datos de entrada del billete
     * @param sorteo entidad del sorteo asociada al billete
     * @param cliente entidad del cliente (puede ser null si no está asignado)
     * @return instancia de {@link Billete} lista para persistir
     */
    public Billete toEntity(BilleteRequestDTO dto, Sorteo sorteo, Cliente cliente) {
        Billete billete = new Billete();
        billete.setNumero(dto.getNumero());
        billete.setPrecio(dto.getPrecio());
        billete.setEstado(EstadoBillete.valueOf(dto.getEstado()));
        billete.setSorteo(sorteo);
        billete.setCliente(cliente);
        return billete;
    }

    /**
     * Convierte una entidad {@link Billete} a un objeto {@link BilleteResponseDTO}.
     *
     * @param billete entidad de la base de datos
     * @return DTO con la información del billete para enviar al cliente
     */
    public BilleteResponseDTO toResponseDTO(Billete billete) {
        BilleteResponseDTO dto = new BilleteResponseDTO();
        dto.setId(billete.getId());
        dto.setNumero(billete.getNumero());
        dto.setPrecio(billete.getPrecio());
        dto.setEstado(billete.getEstado().name());

        if (billete.getSorteo() != null) {
            dto.setSorteoId(billete.getSorteo().getId());
            dto.setSorteoNombre(billete.getSorteo().getNombre());
        }

        if (billete.getCliente() != null) {
            dto.setClienteId(billete.getCliente().getId());
            dto.setClienteNombre(billete.getCliente().getNombre());
        }

        return dto;
    }
}
