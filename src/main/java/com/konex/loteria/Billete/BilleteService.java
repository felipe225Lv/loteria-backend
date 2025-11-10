package com.konex.loteria.Billete;

import com.konex.loteria.Billete.DTOs.BilleteRequestDTO;
import com.konex.loteria.Billete.DTOs.BilleteResponseDTO;
import java.util.List;

/**
 * Interfaz de servicio que define las operaciones principales para la gestión de billetes.
 *
 * <p>Esta capa actúa como un contrato que las implementaciones deben cumplir,
 * separando la lógica de negocio del acceso a datos.</p>
 */
public interface BilleteService {

    /**
     * Obtiene todos los billetes registrados.
     *
     * @return lista de {@link BilleteResponseDTO}
     */
    List<BilleteResponseDTO> getBilletes();

    /**
     * Obtiene un billete por su identificador único.
     *
     * @param id identificador del billete
     * @return objeto {@link BilleteResponseDTO} si existe
     */
    BilleteResponseDTO get(Long id);

    /**
     * Crea un nuevo billete en el sistema.
     *
     * @param billeteRequestDTO datos del billete a crear
     * @return billete creado como {@link BilleteResponseDTO}
     */
    BilleteResponseDTO save(BilleteRequestDTO billeteRequestDTO);

    /**
     * Actualiza la información de un billete existente.
     *
     * @param id identificador del billete a actualizar
     * @param billeteRequestDTO nuevos datos del billete
     * @return billete actualizado como {@link BilleteResponseDTO}
     */
    BilleteResponseDTO update(Long id, BilleteRequestDTO billeteRequestDTO);

    /**
     * Elimina un billete del sistema.
     *
     * @param id identificador del billete a eliminar
     */
    void delete(Long id);

    /**
     * Obtiene los billetes de cada cliente.
     *
     * @param clienteId identificador del cliente para traer los billetes que tiene
     */
    List<BilleteResponseDTO> getBilletesVendidosPorCliente(Long clienteId);

    /**
     * Vender un billete del sistema
     *
     * @param billeteId identificador del billete el cual se va a vender
     * @param clienteId identificador del cliente que va a comprar el billete
     */
    BilleteResponseDTO venderBillete(Long billeteId, Long clienteId);
}
