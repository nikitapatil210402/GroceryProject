package com.GrocerySystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GrocerySystem.entity.Grocery;
import com.GrocerySystem.repository.GroceryRepository;

@Service
public class GroceryService {
	
	@Autowired
	private GroceryRepository gRepo;
	public void save(Grocery g)
	{
		gRepo.save(g);
		
	}
	public List<Grocery> getAllGrocery(){
		return gRepo.findAll();
	}
	
	public Grocery getGroceryById(int id)
	{
		return gRepo.findById((long) id).get();
	}
	public void deleteById(int id) {
		gRepo.deleteById((long) id);
	}

}
