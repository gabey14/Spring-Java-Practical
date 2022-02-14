package com.example.trial.controller;

import com.example.trial.entity.Product;
import com.example.trial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/products")
        public List<Product> addProducts(@RequestBody List<Product> products){
            return service.saveProducts(products);
    }

    @GetMapping("/products/{pid}")
    public Product getProductsById(@PathVariable int pid){
        return service.getProductById(pid);
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @DeleteMapping("/product/{pid}")
    public void deleteProducts(@PathVariable int pid){
        service.delete(pid);
    }

//    @PutMapping("/product")
//    public void updateProduct(@RequestBody Product product){
//        service.updateProduct(product);
//    }
    
    @GetMapping("/viewallproducts")
    public String viewallproducts(Model model){
    	model.addAttribute("allproducts",getProducts());
    	return "viewallproducts";
    	
    }
    
    @GetMapping("/viewproduct/{pid}")
    public String viewproduct(@PathVariable int pid,Model model) {
    	model.addAttribute("viewproduct", getProductsById(pid));
    	return "viewproduct";
    }
    
    @GetMapping("/addproduct")
    public String addproduct(Model model){
    	model.addAttribute("allproducts", getProducts());
    	return "addproduct";
    }
    
    @GetMapping("/productform")
    public String productform(Model model) {
    	Product product = new Product();
    	model.addAttribute("product",product);
    	return "productform";
    }
    
    @PostMapping("/saveproduct")
    public String saveproduct(@ModelAttribute Product product) {
    	service.saveProduct(product);
    	return "redirect:/viewallproducts";
    }
    
//    Update Code Assignment by Sir
    
    @GetMapping("/updateform/{pid}")
    public String updateProduct(@PathVariable Integer pid, Model model) {
    	
    	Product product = service.getProductById(pid);
    	model.addAttribute("product",product);
    	return "updateform";
    }
    
    
    @PostMapping("/updateproduct")
    public String updateProduct(@ModelAttribute Product product) {
    	service.updateProduct(product);
    	return "redirect:/viewallproducts";
    }
    
    
//    @PutMapping("/update")
//    public String updateProduct(@RequestBody Product product) {
//    	System.out.println(product);
//    	service.updateProduct(product);
//    	return "redirect:/viewallproducts";
//    }
    
    
//    Self Implemented
    @GetMapping("/deleteproduct/{pid}")
    public String deleteProduct(@PathVariable Integer pid) {
//        Product product = service.getProductById(pid);
        service.delete(pid);
//        model.addAttribute("allproducts",getProducts());
        return "redirect:/viewallproducts";
    }


}

