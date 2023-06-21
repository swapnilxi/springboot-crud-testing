package com.swapnilxi.springcrudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swapnilxi.springcrudtest.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
