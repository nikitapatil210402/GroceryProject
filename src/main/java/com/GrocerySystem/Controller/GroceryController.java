package com.GrocerySystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.GrocerySystem.entity.Grocery;
import com.GrocerySystem.entity.MyGroceryList;
import com.GrocerySystem.repository.GroceryRepository;
import com.GrocerySystem.service.GroceryService;
import com.GrocerySystem.service.MyGroceryListService;

@Controller
public class GroceryController {
    
    @Autowired
    private GroceryService service;
    
    @Autowired
    private MyGroceryListService myGroceryService;
    
    @Autowired
    private GroceryRepository groceryRepository;
    
    @GetMapping("/")
    public String home() {
        return "home";    
    }
    
    // Consolidate the register functionality into one method
    @GetMapping("/grocery_register")
    public String groceryRegisterForm(Model model) {
        model.addAttribute("grocery", new Grocery());
        return "groceryRegister";
    }
    
    @PostMapping("/grocery_register")
    public String registerGrocery(@ModelAttribute Grocery grocery) {
        grocery.setCategory("Fruit");  // Set the category as "Fruit"
        groceryRepository.save(grocery);  // Save the new grocery to the database
        return "redirect:/available_grocery";  // Redirect to the fruits page
    }

    @GetMapping("available_grocery")
    public ModelAndView getAllGrocery() {
        List<Grocery> list = service.getAllGrocery();
        return new ModelAndView("groceryList", "grocery", list);
    }
    
    @PostMapping("/save")
    public String addGrocery(@ModelAttribute Grocery g) {
        service.save(g);
        return "redirect:/my_grocery";
    }
    
    @GetMapping("/my_grocery")
    public String getMyGrocery(Model model) {
        List<MyGroceryList> list = myGroceryService.getAllGrocery();
        model.addAttribute("groceryList", list);
        return "myGrocery";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Grocery g = service.getGroceryById(id);
        if (g != null) {
            MyGroceryList mb = new MyGroceryList(g.getId(), g.getName(), g.getProduct(), g.getPrice());
            myGroceryService.saveMyGrocery(mb);
        }
        return "redirect:/my_grocery";
    }

    @RequestMapping("editGrocery/{id}")
    public String editGrocery(@PathVariable("id") int id, Model model) {
        Grocery g = service.getGroceryById(id);
        model.addAttribute("grocery", g);
        return "groceryEdit";
    }

    @RequestMapping("/deleteGrocery/{id}")
    public String deleteGrocery(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/available_grocery";
    }
    @GetMapping("/about")
    public String about() {
        return "about"; // Maps to the about.html template
    }
    @GetMapping("/availablegrocery")
    public String showFruits(Model model) {
        List<Grocery> fruits = groceryRepository.findByCategory("Fruit");  // Filter by category
        model.addAttribute("grocery", fruits);
        return "availablegrocery";
    }
    @GetMapping("/grocerylist")  // For getting all groceries (example of different URL)
    public String getAllGrocery(Model model) {
        // your logic here
    	return "grocerylist";
    }
    
    
    @GetMapping("/fruits")
    public String showFruits() {
        return "fruits"; // This will return fruits.html
    }

    @GetMapping("/vegetables")
    public String showVegetables() {
        return "vegetables"; // This will return vegetables.html
    }
    
   
    
}
