package com.GrocerySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrocerySystem.entity.MyGroceryList;

@Repository
public interface MyGroceryRepository extends JpaRepository<MyGroceryList,Integer>{

}
