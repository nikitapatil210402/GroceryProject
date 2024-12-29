package com.GrocerySystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrocerySystem.entity.Grocery;
@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Long> {
    List<Grocery> findByCategory(String category); // Method to fetch groceries by category (e.g., "Fruits")
}
