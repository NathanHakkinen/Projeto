package com.esx.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esx.model.Product;
import com.esx.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
      @Autowired
	 private ProductRepository repo;
      
      public List<Product> listall(){
    	  return repo.findAll();
      }
      
      public Product get(int id) {
    	  return repo.findById(id).get();
      }
      
      public void save(Product product) {
    	   repo.save(product);
      }
      public void delete(int id) {
    	  repo.deleteById(id);
      }
      
}
