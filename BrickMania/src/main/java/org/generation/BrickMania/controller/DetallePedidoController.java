package org.generation.BrickMania.controller;

import org.generation.BrickMania.producto.model.DetallePedido;
import org.generation.BrickMania.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetallePedidoController {
    
    private final DetallePedidoService detallePedidoService;

    @Autowired
    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping
    public List<DetallePedido> getAllDetalles() {
        return detallePedidoService.getAllDetalles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getDetalleById(@PathVariable("id") Integer id) {
        DetallePedido detalle = detallePedidoService.getDetalleById(id);
        return detalle != null ? ResponseEntity.ok(detalle) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public DetallePedido addDetalle(@RequestBody DetallePedido detallePedido) {
        return detallePedidoService.addDetalle(detallePedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> updateDetalle(@PathVariable("id") Integer id, @RequestBody DetallePedido detallePedido) {
        DetallePedido updated = detallePedidoService.updateDetalle(id, detallePedido);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable("id") Integer id) {
        detallePedidoService.deleteDetalle(id);
        return ResponseEntity.ok().build();
    }
}
