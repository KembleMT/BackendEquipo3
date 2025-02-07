package org.generation.BrickMania.service;

import org.generation.BrickMania.producto.model.CarritoProducto;
import org.generation.BrickMania.repository.CarritoProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoProductoService {

    private final CarritoProductoRepository carritoProductoRepository;

    public CarritoProductoService(CarritoProductoRepository carritoProductoRepository) {
        this.carritoProductoRepository = carritoProductoRepository;
    }

    public List<CarritoProducto> getAllCarritoProductos() {
        return carritoProductoRepository.findAll();
    }

    public Optional<CarritoProducto> getCarritoProductoById(Integer id) {
        return carritoProductoRepository.findById(id);
    }

    public CarritoProducto saveCarritoProducto(CarritoProducto carritoProducto) {
        return carritoProductoRepository.save(carritoProducto);
    }

    public void deleteCarritoProducto(Integer id) {
        carritoProductoRepository.deleteById(id);
    }
}




