package com.crudApp.Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudApp.Main.Entity.Product;
import com.crudApp.Main.Service.CrudService;

@Controller
public class CrudController {
	
	@Autowired
	CrudService crudService;
	
	@GetMapping("/store")
	public String getProducts(Model m) {
		List<Product> list = crudService.getAll();
		m.addAttribute("list", list);
		return "retrievedView";
	}
	
	@PostMapping("/insert")
	public String getInsertView() {
		return "insertView";
	}
	
	@PostMapping("/insertData")
	public String insertData(@ModelAttribute Product product) {
		Product p = crudService.insert(product);
		System.out.println(p);
		return "redirect:/store";
	}
	
	@PostMapping("/update/{id}/{name}/{description}/{price}")
	public String getUpdateView(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("description") String description, @PathVariable("price") String price, Model m) {
		m.addAttribute("id",id);
		m.addAttribute("name", name);
		m.addAttribute("description", description);
		m.addAttribute("price", price);
		return "updateView";
	}
	
	@PostMapping("/updateData")
	public String updateData(@ModelAttribute Product product) {
		Product p = crudService.update(product);
		System.out.println(p);
		return "redirect:/store";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id) {
		crudService.deleteProduct(id);
		return "redirect:/store";
	}
	
}
