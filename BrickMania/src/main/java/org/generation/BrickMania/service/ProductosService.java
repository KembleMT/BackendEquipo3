package org.generation.BrickMania.service;

import java.util.List;
import java.util.Optional;
import org.generation.BrickMania.producto.model.Producto;
import org.generation.BrickMania.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductosService {
	//public static List<Producto> getAllProducts;
	//private final List<Producto> Lista= new ArrayList <Producto> ();
	
	public final ProductoRepository productosRepository;
	
	@Autowired
	public ProductosService(ProductoRepository productosRepository) {
		this.productosRepository = productosRepository;
	}//Autowired ProductosService
	
	public List<Producto> getAllProducts(){
		return productosRepository.findAll();// cambiamos
	}//getAllProducts
	
	public Producto getProduct (Integer id){
		return productosRepository.findById(id).orElseThrow(
		()-> new IllegalArgumentException("El producto con el id [" + id + "] no existe.")
		);
	}//getProduct
	
	public Producto deletProduct(Integer id) {
		Producto prod = null;
		if(productosRepository.existsById(id)) {
		prod = productosRepository.findById(id).get();
		productosRepository.deleteById(id);
		}//if existById
		return prod;
	}//delet

	public Producto addProduct(Producto producto) {
	    Optional<Producto> prod = productosRepository.findByNombre(producto.getNombre());	
	    if (prod.isEmpty()) {
	        Producto nuevoProducto = new Producto(
	            producto.getNombre(),
	            producto.getDescripcion(),
	            producto.getPrecio(),
	            producto.getCategoria(),
	            producto.getImagenUrl() // ✅ Asegura que la imagen se guarde
	        );
	        return productosRepository.save(nuevoProducto);
	    } else {
	        return null;
	    }
	}
//addProducto
	
	public Producto updateProduct(Integer id, String nombre, String descripcion, Double precio) {
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
