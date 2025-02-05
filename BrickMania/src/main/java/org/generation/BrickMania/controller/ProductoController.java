package org.generation.BrickMania.controller;

import java.util.List;

import org.generation.BrickMania.producto.model.Producto;
import org.generation.BrickMania.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/Producto/")
public class ProductoController {
	private final ProductosService productoService;
	
	@Autowired 
	public ProductoController (ProductosService productoService) {
		super();
		this.productoService = productoService;
	}
	@GetMapping
	public List<Producto> getProductos() {
		Producto producto = new Producto("Lego Set City", "Set de construcción de ciudad.", 49.99);
				return ProductosService.getAllProducts;
	}//getProductos
	
}
