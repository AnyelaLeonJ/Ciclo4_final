package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anyela León
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repositorio;

    public List<Product> listAll() {
        return repositorio.listAll();
    }

    public Optional<Product> getSupplement(String reference) {
        return repositorio.getSupplement(reference);
    }

    public Product create(Product supplement) {
        if (supplement.getReference() == null) {
            return supplement;
        } else {
            return repositorio.create(supplement);
        }
    }

    public Product update(Product supplement) {

        if (supplement.getReference() != null) {
            Optional<Product> supplementDb = repositorio.getSupplement(supplement.getReference());
            if (!supplementDb.isEmpty()) {
                if (supplement.getBrand() != null) {
                    supplementDb.get().setBrand(supplement.getBrand());
                }
                if (supplement.getCategory() != null) {
                    supplementDb.get().setCategory(supplement.getCategory());
                }

                if (supplement.getDescription() != null) {
                    supplementDb.get().setDescription(supplement.getDescription());
                }
                if (supplement.getPrice() != 0.0) {
                    supplementDb.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity() != 0) {
                    supplementDb.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography() != null) {
                    supplementDb.get().setPhotography(supplement.getPhotography());
                }
                supplementDb.get().setAvailability(supplement.isAvailability());
                repositorio.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return supplement;
            }
        } else {
            return supplement;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplement(reference).map(supplement -> {
            repositorio.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Product> productsByPrice(double price) {
        return repositorio.productsByPrice(price);
    }

    public List<Product> findByDescriptionLike(String description) {
        return repositorio.findByDescriptionLike(description);
    }
}
