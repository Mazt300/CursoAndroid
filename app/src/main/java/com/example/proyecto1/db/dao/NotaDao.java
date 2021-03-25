package com.example.proyecto1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotaDao {
    @Insert
    void Insert(NotaEntity notaEntity);
    @Update
    void Update(NotaEntity notaEntity);

    @Query("DELETE FROM notas")
    void Delete(NotaEntity notaEntity);
    @Query("DELETE FROM NOTAS WHERE Id = :idNota")
    void DeleteById(int idNota);

    @Query("SELECT * FROM NOTAS ORDER BY Titulo ASC")
//    LiveData Permite cargar lista dinamica e iterar sobre ellas
    LiveData<List<NotaEntity>> GetAll();

    @Query("SELECT * FROM NOTAS WHERE Favorita = 'true'")
    LiveData<List<NotaEntity>> GetAllFavoritas();




//    void favoritaNotaClick(NotaEntity notaEntity);
}
