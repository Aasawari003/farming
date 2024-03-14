package com.farming.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farming.models.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String query, String query2);
    // Add custom methods for searching products if needed
 }
