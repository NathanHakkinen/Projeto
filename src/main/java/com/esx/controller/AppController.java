package com.esx.controller;
import java.util.List;
import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.esx.dao.ProductService;
import com.esx.model.Product;

@Controller
public class AppController {
	@Autowired
	private ProductService service;
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listall();
		model.addAttribute("listProducts", listProducts);
		
	
		return "index";
	}
	@RequestMapping("/cadastro")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "cadastro";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name="id")int id) {
		ModelAndView mav = new ModelAndView("edit");
		Product product = service.get(id);
		mav.addObject("product", product);
		return mav; 
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveProduct(Product product) {
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id")int id) {
		      service.delete(id);
		return "redirect:/";
	}

}
