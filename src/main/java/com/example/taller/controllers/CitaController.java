package com.example.taller.controllers;

import com.example.taller.models.Cita;
import com.example.taller.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService service;

    @GetMapping("/agendar")
    public String agendarCitaForm(Model model) {
        model.addAttribute("cita", new Cita());
        return "citas/agendar-cita";
    }

    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute Cita cita) {
        if (cita.getId() != null) {
            service.actualizarCita(cita);
        } else {
            service.guardarCita(cita);
        }
        return "redirect:/citas/ver";
    }

    @GetMapping("/ver")
    public String verCitas(Model model) {
        model.addAttribute("listaCitas", service.listarCitas());
        return "citas/ver-cita";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCita(@PathVariable Long id) {
        service.eliminarCita(id);
        return "redirect:/citas/ver";
    }

    @GetMapping("/editar/{id}")
    public String editarCitaForm(@PathVariable Long id, Model model) {
        Cita cita = service.obtenerCitaPorId(id);
        model.addAttribute("cita", cita);
        return "citas/agendar-cita";
    }
}
