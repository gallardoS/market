package com.swamigallardo.market.domain.repository;

import com.swamigallardo.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(Long categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(Long productId);
    Product save(Product product);
    void delete(Long productId);
}
