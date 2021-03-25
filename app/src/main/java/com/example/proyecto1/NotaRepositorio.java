package com.example.proyecto1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.proyecto1.db.NotaRoomDatabase;
import com.example.proyecto1.db.dao.NotaDao;
import com.example.proyecto1.db.entity.NotaEntity;

import java.util.List;

public class NotaRepositorio {
    private NotaDao notaDao;

    private LiveData<List<NotaEntity>> allNotas;
    private LiveData<List<NotaEntity>> allNotasFavoritas;

    public NotaRepositorio(Application application){
        NotaRoomDatabase db = NotaRoomDatabase.getDatabase(application);
        notaDao = db.notaDao;
        allNotas = notaDao.GetAll();
        allNotasFavoritas = notaDao.GetAllFavoritas();
    }

    private LiveData<List<NotaEntity>> GetAll(){
      return allNotas;
    };
    private LiveData<List<NotaEntity>> GetAllFavs(){
        return allNotasFavoritas;
    };
}
