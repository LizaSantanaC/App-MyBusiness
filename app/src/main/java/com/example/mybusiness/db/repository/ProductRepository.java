package com.example.mybusiness.db.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import com.example.mybusiness.db.dao.ProductDao;
import com.example.mybusiness.db.entity.Product;
import com.example.mybusiness.room.MyBusinessDB;

import java.util.List;

public class ProductRepository {
    private ProductDao mProductDao;
    private LiveData<List<Product>> mAllProducts;

    public ProductRepository(Application application){
        MyBusinessDB db = MyBusinessDB.getDatabase(application);
        mProductDao = db.productDao();
        mAllProducts = mProductDao.getAll();
    }

    public LiveData<List<Product>> getAllProducts() {
        return mAllProducts;
    }

    public void insert(Product product) {
        MyBusinessDB.databaseWriteExecutor.execute(() -> {
            mProductDao.insert(product);
        });
    }

    public void update(Product product) {
        MyBusinessDB.databaseWriteExecutor.execute(() -> {
            mProductDao.update(
                    product
            );
        });
    }

    public void delete(Product product) {
        MyBusinessDB.databaseWriteExecutor.execute(() -> {
            mProductDao.delete(product);
        });
    }


    public LiveData<Product> findByCode(String code) {
        return mProductDao.findByCode(code);
    }
}
