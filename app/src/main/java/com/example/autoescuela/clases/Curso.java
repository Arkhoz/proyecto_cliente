package com.example.autoescuela.clases;

public class Curso {
        private Estudiante est;
        private Profesor pro;
        private String hora;
        private String dia;
        private String categoria;

    public Curso( Estudiante est, Profesor pro, String hora, String dia, String categoria) {
        this.est = est;
        this.pro = pro;
        this.hora = hora;
        this.dia = dia;
        this.categoria = categoria;
    }

    public Estudiante getEst() {
        return est;
    }

    public void setEst(Estudiante est) {
        this.est = est;
    }

    public Profesor getPro() {
        return pro;
    }

    public void setPro(Profesor pro) {
        this.pro = pro;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
