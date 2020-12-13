package com.example.mybusiness.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mybusiness.db.dao.ProductDao;
import com.example.mybusiness.db.entity.Categoria;
import com.example.mybusiness.db.entity.Product;
import com.example.mybusiness.db.entity.Usuario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product.class, Categoria.class, Usuario.class}, version = 1, exportSchema = false)
public abstract class MyBusinessDB extends RoomDatabase {
    public abstract ProductDao productDao();

    private static volatile com.example.mybusiness.room.MyBusinessDB INSTANCE;
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static com.example.mybusiness.room.MyBusinessDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (com.example.mybusiness.room.MyBusinessDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            com.example.mybusiness.room.MyBusinessDB.class, "mybusuness_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
