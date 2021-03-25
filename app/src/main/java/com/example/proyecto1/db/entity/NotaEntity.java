package com.example.proyecto1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notas")
public class NotaEntity {
    @PrimaryKey(autoGenerate = true)
    public int Id;

//    @ColumnInfo(name = "")
    public String Titulo;
    public String Contenido;
    public boolean Favorita;
    public String Color;

    public NotaEntity( String titulo, String contenido, boolean favorita, String color) {
        Titulo = titulo;
        Contenido = contenido;
        Favorita = favorita;
        Color = color;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
