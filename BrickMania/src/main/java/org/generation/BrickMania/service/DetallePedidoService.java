package org.generation.BrickMania.service;

import java.util.List;
import java.util.Optional;

import org.generation.BrickMania.producto.model.DetallePedido;
import org.generation.BrickMania.repository.detallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoService {

    private final detallePedidoRepository detallePedidoRepository;

    @Autowired
    public DetallePedidoService(detallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    public List<DetallePedido> getAllDetalles() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedido getDetalleById(Integer id) {
        Optional<DetallePedido> optional = detallePedidoRepository.findById(id);
        return optional.orElse(null);
    }

    public DetallePedido addDetalle(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public DetallePedido updateDetalle(Integer id, DetallePedido detallePedidoUpdated) {
        Optional<DetallePedido> optional = detallePedidoRepository.findById(id);
        if (optional.isPresent()) {
            DetallePedido detallePedido = optional.get();
            detallePedido.setCantidad(detallePedidoUpdated.getCantidad());
            detallePedido.setPrecio(detallePedidoUpdated.getPrecio());
         
            return detallePedidoRepository.save(detallePedido);
        }
        return null;
    }

    public void deleteDetalle(Integer id) {
        detallePedidoRepository.deleteById(id);
    }
}

