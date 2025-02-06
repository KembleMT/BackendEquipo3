package org.generation.BrickMania.controller;

import org.generation.BrickMania.producto.model.MetodoPago;
import org.generation.BrickMania.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodos")
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    @Autowired
    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping
    public List<MetodoPago> getAllMetodos() {
        return metodoPagoService.getAllMetodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getMetodoById(@PathVariable("id") Long id) {
        MetodoPago metodo = metodoPagoService.getMetodoById(id);
        return metodo != null ? ResponseEntity.ok(metodo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public MetodoPago addMetodo(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.addMetodo(metodoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> updateMetodo(@PathVariable("id") Long id, @RequestBody MetodoPago metodoPago) {
        MetodoPago updated = metodoPagoService.updateMetodo(id, metodoPago);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodo(@PathVariable("id") Long id) {
        metodoPagoService.deleteMetodo(id);
        return ResponseEntity.ok().build();
    }
}
