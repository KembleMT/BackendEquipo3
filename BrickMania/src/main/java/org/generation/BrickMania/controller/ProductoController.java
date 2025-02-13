package org.generation.BrickMania.controller;

import java.util.List;

import org.generation.BrickMania.producto.model.Producto;
import org.generation.BrickMania.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/Producto/")
public class ProductoController {
    private final ProductosService productoService;

    @Autowired 
    public ProductoController (ProductosService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getProductos() {
        return productoService.getAllProducts();
    }

    @GetMapping(path="{productoId}")
    public Producto getProducto(@PathVariable("productoId") Integer id) {
        return productoService.getProduct(id);
    }

    @PostMapping
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.addProduct(producto);
    }

    @DeleteMapping(path="{productoId}")
    public Producto deleteProducto(@PathVariable("productoId") Integer id) {
        return productoService.deletProduct(id);
    }

    // ✅ Corrección: Ahora sí modifica el producto en la BD en lugar de duplicarlo
    @PutMapping(path="{productoId}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("productoId") Integer id, @RequestBody Producto productoActualizado) {
        Producto productoEditado = productoService.updateProduct(id, productoActualizado);

        if (productoEditado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productoEditado);
    }
}
