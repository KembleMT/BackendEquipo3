package org.generation.BrickMania.service;

import org.generation.BrickMania.producto.model.Pedido;
import org.generation.BrickMania.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidosRepository) {
        this.pedidoRepository = pedidosRepository;
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }//getAll

    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }//get

    public Pedido addPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }//add

    public Pedido updatePedido(Long id, Pedido pedidoUpdated) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
            Pedido pedido = optional.get();
            pedido.setTotalPago(pedidoUpdated.getTotalPago());
            pedido.setFechaCompra(pedidoUpdated.getFechaCompra());
            pedido.setIdMetodoFk(pedidoUpdated.getIdMetodoFk());
            pedido.setIdEstadoFk(pedidoUpdated.getIdEstadoFk());
            return pedidoRepository.save(pedido);
        }//if
        return null;
    }//update

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }//delete
}

