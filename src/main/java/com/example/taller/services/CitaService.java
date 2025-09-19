package com.example.taller.services;

import com.example.taller.models.Cita;
import com.example.taller.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository repository;

    public List<Cita> listarCitas() {
        return repository.findAll();
    }

    public void guardarCita(Cita cita) {
        repository.save(cita);
    }

    public void actualizarCita(Cita cita) {
        Cita citaExistente = repository.findById(cita.getId())
                .orElseThrow(() -> new IllegalArgumentException("ID no encontrado: " + cita.getId()));

        citaExistente.setNombreDueno(cita.getNombreDueno());
        citaExistente.setNombreMascota(cita.getNombreMascota());
        citaExistente.setTipoMascota(cita.getTipoMascota());
        citaExistente.setFecha(cita.getFecha());
        citaExistente.setHora(cita.getHora());
        citaExistente.setMotivo(cita.getMotivo());

        repository.save(citaExistente);
    }

    public void eliminarCita(Long id) {
        repository.deleteById(id);
    }

    public Cita obtenerCitaPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID no encontrado: " + id));
    }
}
