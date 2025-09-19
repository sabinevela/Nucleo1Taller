package com.example.taller.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreDueno;
    private String nombreMascota;
    private String tipoMascota;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreDueno() {
        return nombreDueno;
    }
    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }
    public String getNombreMascota() {
        return nombreMascota;
    }
    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
    public String getTipoMascota() {
        return tipoMascota;
    }
    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
