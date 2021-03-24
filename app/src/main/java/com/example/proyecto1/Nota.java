package com.example.proyecto1;

public class Nota {
    private String Nota;
    private String Contenido;
    private boolean Favorita;
    private int Color;

    public Nota(String nota, String contenido, boolean favorita, int color) {
        Nota = nota;
        Contenido = contenido;
        Favorita = favorita;
        Color = color;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String nota) {
        Nota = nota;
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
