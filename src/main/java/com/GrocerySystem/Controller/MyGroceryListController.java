package com.GrocerySystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GrocerySystem.service.MyGroceryListService;

@Controller
public class MyGroceryListController {
	
	@Autowired
	private MyGroceryListService service;
	
	@RequestMapping("deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id")int id) {
		service.deleteById(id);
		
	return "redirect:/my_grocery";
}
}
