package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Anyela León
 */
@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService servicio;

    @GetMapping("/all")
    public List<Product> listAll() {
        return servicio.listAll();
    }

    @GetMapping("/{reference}")
    public Optional<Product> getSupplement(@PathVariable("reference") String reference) {
        return servicio.getSupplement(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product gadget) {
        return servicio.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product gadget) {
        return servicio.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return servicio.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Product> gadgetsByPrice(@PathVariable("price") double precio) {
        return servicio.productsByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Product> findByDescriptionLike(@PathVariable("description") String description) {
        return servicio.findByDescriptionLike(description);
    }
}