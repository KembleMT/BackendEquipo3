package org.generation.BrickMania.controller;

import java.util.List;

import org.generation.BrickMania.producto.model.Producto;
import org.generation.BrickMania.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/Producto/")
public class ProductoController {
	private final ProductosService productoService;
	
	@Autowired 
	public ProductoController (ProductosService productoService) {
		this.productoService = productoService;
	}//constructor
	
	//1. Obtiene todos los usuarios
	@GetMapping
	public List<Producto> getProductos() {
				return productoService.getAllProducts();
	}//getProductos
	
	// 2️. Obtener un producto por ID
    @GetMapping(path="{productoId}")
    public Producto getProducto(@PathVariable("productoId") Integer id) {
        return productoService.getProduct(id);
    }

    //3️. Agregar un nuevo producto
    @PostMapping
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.addProduct(producto);
    }

    //4️. Eliminar un producto por ID
    @DeleteMapping(path="{productoId}")
    public Producto deleteProducto(@PathVariable("productoId") Integer id) {
        return productoService.deletProduct(id);
    }
	
	
}
