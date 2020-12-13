package com.example.mybusiness.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.mybusiness.room.MyBusinessDB;
import com.example.mybusiness.db.entity.Product;
import com.example.mybusiness.db.repository.ProductRepository;


import java.util.List;

public class ProductViewModel extends ViewModel {
    private ProductRepository mRepository;
    private final LiveData<List<Product>> mAllProducts;

    public ProductViewModel() {
        super();
       mRepository = new ProductRepository(MyAplicaction.getInstance());
       mAllProducts= mRepository.getAllProducts();
    }

    public LiveData<List<Product>> getAllProducts() {
        return mAllProducts;
    }

    public void insert(Product product) {
        mRepository.insert(product);
    }

    public void update(Product product) {
        mRepository.update(product);
    }

    public void delete(Product product) {
        mRepository.delete(product);
    }

    public LiveData<Product> findByCode(String code) {
        return mRepository.findByCode(code);
    }

}
