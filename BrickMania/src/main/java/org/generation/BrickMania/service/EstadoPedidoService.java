package org.generation.BrickMania.service;

import org.generation.BrickMania.producto.model.EstadoPedido;
import org.generation.BrickMania.repository.EstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoPedidoService {

    private final EstadoPedidoRepository estadoPedidoRepository;

    @Autowired
    public EstadoPedidoService(EstadoPedidoRepository estadoPedidoRepository) {
        this.estadoPedidoRepository = estadoPedidoRepository;
    }

    public List<EstadoPedido> getAllEstados() {
        return estadoPedidoRepository.findAll();
    }

    public EstadoPedido getEstadoById(Long id) {
        Optional<EstadoPedido> optional = estadoPedidoRepository.findById(id);
        return optional.orElse(null);
    }

    public EstadoPedido addEstado(EstadoPedido estadoPedido) {
        return estadoPedidoRepository.save(estadoPedido);
    }

    public EstadoPedido updateEstado(Long id, EstadoPedido estadoPedidoUpdated) {
        Optional<EstadoPedido> optional = estadoPedidoRepository.findById(id);
        if (optional.isPresent()) {
            EstadoPedido estadoPedido = optional.get();
            estadoPedido.setEstado(estadoPedidoUpdated.getEstado());
            return estadoPedidoRepository.save(estadoPedido);
        }
        return null;
    }

    public void deleteEstado(Long id) {
        estadoPedidoRepository.deleteById(id);
    }//revisar un if en caso de que se elimine el usuario asociado a este pedido
}

