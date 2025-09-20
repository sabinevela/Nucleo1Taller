package com.example.taller.controllers;

import com.example.taller.models.Cita;
import com.example.taller.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String guardarCita(@ModelAttribute Cita cita, RedirectAttributes redirectAttributes) {
        try {
            if (cita.getId() != null) {
                service.actualizarCita(cita);
                redirectAttributes.addFlashAttribute("mensaje", "Cita actualizada exitosamente");
            } else {
                service.guardarCita(cita);
                redirectAttributes.addFlashAttribute("mensaje", "Cita agendada exitosamente");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al guardar la cita: " + e.getMessage());
        }
        return "redirect:/citas/ver";
    }

    @GetMapping("/ver")
    public String verCitas(Model model) {
        model.addAttribute("listaCitas", service.listarCitas());
        return "citas/ver-cita";
    }

    @GetMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String eliminarCita(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            service.eliminarCita(id);
            redirectAttributes.addFlashAttribute("mensaje", "Cita eliminada exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar la cita: " + e.getMessage());
        }
        return "redirect:/citas/ver";
    }

    @GetMapping("/editar/{id}")
    public String editarCitaForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Cita cita = service.obtenerCitaPorId(id);
            model.addAttribute("cita", cita);
            return "citas/agendar-cita";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Cita no encontrada");
            return "redirect:/citas/ver";
        }
    }
}