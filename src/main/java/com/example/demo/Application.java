package com.example.demo;

import com.example.demo.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.repository.crud.ProductCrudRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private ProductCrudRepository supRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		supRepo.deleteAll();
	}
}
