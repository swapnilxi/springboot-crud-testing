package com.swapnilxi.springcrudtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.swapnilxi.springcrudtest.entity.Product;
import com.swapnilxi.springcrudtest.repository.ProductRepository;

@SpringBootApplication
public class SpringcrudtestApplication {

	public static void main(String[] args) {
		System.out.println("swapnil");
		SpringApplication.run(SpringcrudtestApplication.class, args);

	}
	@Bean
    public CommandLineRunner initializeData(ProductRepository productRepository) {
        return args -> {
            // Create and save dummy data
            Product product1 = new Product();
            product1.setName("Dummy Product 1");
            product1.setQuantity(10);
            product1.setPrice(10.99);

            Product product2 = new Product();
            product2.setName("Dummy Product 2");
            product2.setQuantity(20);
            product2.setPrice(19.99);

            Product product3 = new Product();
            product3.setName("Dummy Product 3");
            product3.setQuantity(5);
            product3.setPrice(5.99);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);

            System.out.println("Dummy data saved!");
        };

	}
}
