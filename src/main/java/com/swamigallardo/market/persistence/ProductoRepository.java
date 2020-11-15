package com.swamigallardo.market.persistence;

import com.swamigallardo.market.domain.Product;
import com.swamigallardo.market.domain.repository.ProductRepository;
import com.swamigallardo.market.persistence.crud.ProductoCrudRepository;
import com.swamigallardo.market.persistence.entity.Producto;
import com.swamigallardo.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductMapper mapper;

    private ProductoCrudRepository productoCrudRepository;

    @Override
    public List<Product> getAll(){
        return mapper.toProducts((List<Producto>) productoCrudRepository.findAll());
    }

    @Override
    public Optional<List<Product>> getByCategory(Long categoryId){
        return Optional.of(mapper.toProducts(productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId)));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true)
                .map(productos -> mapper.toProducts(productos));
    }

    @Override
    public Optional<Product> getProduct(Long productId){
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product){

        return mapper.toProduct(productoCrudRepository.save(mapper.toProducto(product)));
    }

    @Override
    public void delete(Long productId){
        productoCrudRepository.deleteById(productId);
    }
}
