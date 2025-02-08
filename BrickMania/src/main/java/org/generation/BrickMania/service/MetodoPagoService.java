package org.generation.BrickMania.service;

import java.util.List;
import java.util.Optional;

import org.generation.BrickMania.producto.model.MetodoPago;
import org.generation.BrickMania.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;

    @Autowired
    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    public List<MetodoPago> getAllMetodos() {
        return metodoPagoRepository.findAll();
    }

    public MetodoPago getMetodoById(Integer id) {
        Optional<MetodoPago> optional = metodoPagoRepository.findById(id);
        return optional.orElse(null);
    }

    public MetodoPago addMetodo(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public MetodoPago updateMetodo(Integer id, MetodoPago metodoPagoUpdated) {
        Optional<MetodoPago> optional = metodoPagoRepository.findById(id);
        if (optional.isPresent()) {
            MetodoPago metodoPago = optional.get();
            metodoPago.setMetodo(metodoPagoUpdated.getMetodo());
            // Aquí puedes agregar más actualizaciones según tu modelo
            return metodoPagoRepository.save(metodoPago);
        }
        return null;
    }

    public void deleteMetodo(Integer id) {
        metodoPagoRepository.deleteById(id);
    }
}
