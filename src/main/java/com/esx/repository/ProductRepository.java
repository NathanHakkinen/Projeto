package com.esx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esx.model.Product;

public interface ProductRepository extends JpaRepository<Product,  Integer>{

}
