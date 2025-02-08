package org.generation.BrickMania.controller;

import org.generation.BrickMania.producto.model.EstadoPedido;
import org.generation.BrickMania.service.EstadoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoPedidoController {

    private final EstadoPedidoService estadoPedidoService;

    @Autowired
    public EstadoPedidoController(EstadoPedidoService estadoPedidoService) {
        this.estadoPedidoService = estadoPedidoService;
    }

    @GetMapping
    public List<EstadoPedido> getAllEstados() {
        return estadoPedidoService.getAllEstados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPedido> getEstadoById(@PathVariable("id") Integer id) {
        EstadoPedido estado = estadoPedidoService.getEstadoById(id);
        return estado != null ? ResponseEntity.ok(estado) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public EstadoPedido addEstado(@RequestBody EstadoPedido estadoPedido) {
        return estadoPedidoService.addEstado(estadoPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoPedido> updateEstado(@PathVariable("id") Integer id, @RequestBody EstadoPedido estadoPedido) {
        EstadoPedido updated = estadoPedidoService.updateEstado(id, estadoPedido);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable("id") Integer id) {
        estadoPedidoService.deleteEstado(id);
        return ResponseEntity.ok().build();
    } //revisar si hay que eliminar junto con id de usuario
}

