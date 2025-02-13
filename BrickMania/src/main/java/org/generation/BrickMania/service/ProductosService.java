package org.generation.BrickMania.service;

import java.util.List;
import java.util.Optional;
import org.generation.BrickMania.producto.model.Producto;
import org.generation.BrickMania.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {
    public final ProductoRepository productosRepository;

    @Autowired
    public ProductosService(ProductoRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    public List<Producto> getAllProducts() {
        return productosRepository.findAll();
    }

    public Producto getProduct(Integer id) {
        return productosRepository.findById(id).orElse(null);
    }

    public Producto deletProduct(Integer id) {
        Producto prod = productosRepository.findById(id).orElse(null);
        if (prod != null) {
            productosRepository.deleteById(id);
        }
        return prod;
    }

    public Producto addProduct(Producto producto) {
        Optional<Producto> prod = productosRepository.findByNombre(producto.getNombre());    
        if (prod.isEmpty()) {
            return productosRepository.save(producto);
        } else {
            return null;
        }
    }

    // ✅ Corrige el método updateProduct para evitar duplicaciones
    public Producto updateProduct(Integer id, Producto productoActualizado) {
        Optional<Producto> productoExistente = productosRepository.findById(id);

        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCategoria(productoActualizado.getCategoria());
            producto.setImagenUrl(productoActualizado.getImagenUrl());

            return productosRepository.save(producto); // ✅ Ahora sí actualiza correctamente
        } else {
            return null;
        }
    }
}
