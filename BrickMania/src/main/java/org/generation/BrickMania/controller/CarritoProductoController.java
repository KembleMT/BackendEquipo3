package org.generation.BrickMania.controller;

import org.generation.BrickMania.producto.model.CarritoProducto;
import org.generation.BrickMania.service.CarritoProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrito")
public class CarritoProductoController {

    private final CarritoProductoService carritoProductoService;

    public CarritoProductoController(CarritoProductoService carritoProductoService) {
        this.carritoProductoService = carritoProductoService;
    }

    @GetMapping
    public List<CarritoProducto> getAllCarritoProductos() {
        return carritoProductoService.getAllCarritoProductos();
    }

    @GetMapping("/{id}")
    public Optional<CarritoProducto> getCarritoProductoById(@PathVariable Integer id) {
        return carritoProductoService.getCarritoProductoById(id);
    }

    @PostMapping
    public CarritoProducto addCarritoProducto(@RequestBody CarritoProducto carritoProducto) {
        return carritoProductoService.saveCarritoProducto(carritoProducto);
    }

    @DeleteMapping("/{id}")
    public void deleteCarritoProducto(@PathVariable Integer id) {
        carritoProductoService.deleteCarritoProducto(id);
    }
}

