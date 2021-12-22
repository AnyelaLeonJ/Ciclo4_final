package com.example.demo.repository;

import com.example.demo.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.crud.ProductCrudRepository;

/**
 *
 * @author Anyela León
 */
@Repository
public class ProductRepository {

    @Autowired
    private ProductCrudRepository crudInterface;

    public List<Product> listAll() {
        return crudInterface.findAll();
    }

    public Optional<Product> getSupplement(String reference) {
        return crudInterface.findById(reference);
    }

    public Product create(Product clothe) {
        return crudInterface.save(clothe);
    }

    public void update(Product clothe) {
        crudInterface.save(clothe);
    }

    public void delete(Product clothe) {
        crudInterface.delete(clothe);
    }

    public List<Product> productsByPrice(double precio) {
        return crudInterface.findByPriceLessThanEqual(precio);
    }

    public List<Product> findByDescriptionLike(String description) {
        return crudInterface.findByDescriptionLike(description);
    }
}

