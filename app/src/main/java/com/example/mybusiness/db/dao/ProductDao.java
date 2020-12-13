package com.example.mybusiness.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.mybusiness.db.entity.Product;
import com.my.business.db.entity.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Update(entity = Product.class)
    void update(Product...product);


    @Query("SELECT * FROM productos")
    LiveData<List<Product>> getAll();

    @Transaction
    @Query("SELECT * FROM productos WHERE nombre LIKE :name")
    List<Product> findByName(String name);

    @Transaction
    @Query("SELECT * FROM productos WHERE codigo == :code")
    LiveData<Product> findByCode(String code);

    @Delete
    int delete(Product product);
}
