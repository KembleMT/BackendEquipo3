package org.generation.BrickMania.service;

import java.util.ArrayList;
import java.util.List;
import org.generation.BrickMania.producto.model.Producto;
import org.generation.BrickMania.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.repository.ProductosRepository;

@Service
public class ProductosService {
	public static List<Producto> getAllProducts;
	private final List<Producto> Lista= new ArrayList <Producto> ();
	
	@Autowired
	public ProductosService(ProductoRepository productosRepository) {
		this.productosRepository = productosRepository;
	}//Autowired ProductosService
	
	public Producto getProduct (Long id){
		return ProductoRepository.findById(id).orElseThrow(
		()-> new IllegalArgumentException("El producto con el id [" + id + "] no existe.")
		);
	}//getProduct
	
	public Producto deletProduct(Long id) {
		Producto prod = null;
		if(productosRepository.existsById(id)) {
		prod = productosRepository.findById(id).get();
		prodcutosRepository.deletById(id);
		}//if existById
		return prod;
	}//delet

	public Producto addProduct(Producto producto) {
    	Optional<Producto> prod =
		ProductosRepository.findByNombre(producto.getNombre());	
		if(prod.isEmpty()) {
    	    ProductosRepository.save(producto);
			return producto;
	} else {
		return null;
		}
	}//addProducto
	
	public Producto updateProduct(Long id, String nombre, String categoria, String descripcion, String imagen,
			Double precio) {
		Producto prod = null;
		if (productosRepository.existsById(id)) {
			Producto producto = productosRepository.findById(id).get();
			if (nombre != null)
				producto.setNombre(nombre);
			if (descripcion != null)
				producto.setDescripcion(descripcion);
			if (precio != null)
				producto.setPrecio(precio);
			productosRepository.save(producto);
			prod = producto;
		} // if
		return prod;
	}//upDateProduct
	
	
	
}//ProductosService
