package com.example.autoescuela.clases;

public class Clases {
    String fecha;
    String hora;
    String profesor;

    public Clases(String fecha, String hora, String profesor) {
        this.fecha = fecha;
        this.hora = hora;
        this.profesor = profesor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
