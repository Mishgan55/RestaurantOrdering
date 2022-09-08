package khorsun.app.service;

import khorsun.app.models.Customers;
import khorsun.app.models.Products;

import java.util.List;
//
//interface that operates on methods for CRUD operation with products table
public interface ProductsService<K, T> {
    T show(int id);

    List<T> index();

    void save(Products products);

    void update(int id, Products updatedProducts);

    void delete(int id);
}

