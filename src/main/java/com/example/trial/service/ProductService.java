package com.example.trial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trial.entity.Product;
import com.example.trial.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository; 
	
	//	save single Product
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return repository.save(product);
	}
	
//	save multiple products
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
//	get product by pid
	public Product getProductById(int pid) {
		return repository.findById(pid).orElse(null);
	}
	
//	get all products
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public void delete(int pid) {
		repository.deleteById(pid);
	}
	
	public void updateProduct(Product product) {
		Product existproduct = repository.findById(product.getPid()).orElse(null);
		if(existproduct != null) {
			existproduct.setPname(product.getPname());
			existproduct.setPid(product.getPid());
			existproduct.setPrice(product.getPrice());
			repository.save(existproduct);	
		}
	}
	
}
