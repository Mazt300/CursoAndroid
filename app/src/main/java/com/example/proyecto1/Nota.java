package com.example.proyecto1;

public class Nota {
    private String Titulo;
    private String Contenido;
    private boolean Favorita;
    private int Color;

    public Nota(String titulo, String contenido, boolean favorita, int color) {
        Titulo = titulo;
        Contenido = contenido;
        Favorita = favorita;
        Color = color;
    }
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public boolean isFavorita() {
        return Favorita;
    }

    public void setFavorita(boolean favorita) {
        Favorita = favorita;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }
}
