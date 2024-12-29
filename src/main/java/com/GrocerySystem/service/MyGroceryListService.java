package com.GrocerySystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GrocerySystem.entity.MyGroceryList;
import com.GrocerySystem.repository.MyGroceryRepository;

@Service
public class MyGroceryListService {
	
	@Autowired
	private MyGroceryRepository mygrocery;
	
	public void saveMyGrocery(MyGroceryList grocery) {
		mygrocery.save(grocery);
	}
	
	public List<MyGroceryList> getAllGrocery(){
		return mygrocery.findAll();
	}
	public void deleteById(int id)
	{
		mygrocery.deleteById(id);
	}
}
