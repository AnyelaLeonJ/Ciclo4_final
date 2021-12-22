package com.example.demo.repository.crud;

import com.example.demo.model.Product;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Anyela León
 */
public interface ProductCrudRepository extends MongoRepository<Product, String> {
    public List<Product> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Product> findByDescriptionLike(String description);
}
