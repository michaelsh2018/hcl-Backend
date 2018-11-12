package com.hcl.hackathon.fullstack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.hackathon.fullstack.beans.Product;
import com.hcl.hackathon.fullstack.daos.ProductDao;
import com.hcl.hackathon.fullstack.http.Response;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	public Product getProductById(int id) {
		return productDao.findById(id).get();
	}
	
	public Response saveProduct(Product product) {
		try {
			productDao.save(product);
			return new Response(true);
		}catch (Exception e) {
			return new Response(false);
		}
	}
	
	public Response updateProduct(Product product) {
		try {
			Product p = productDao.getOne(product.getId());
			p.setName(product.getName());
			p.setRating(product.getRating());
			p.setDescription(product.getDescription());
			p.setCategory(product.getCategory());
			p.setImage(product.getImage());
			productDao.save(p);
			return new Response(true);
		} catch (Exception e) {
			return new Response(false);
		}
	}
	
	public Response deleteProduct(int id) {
		try {
			productDao.deleteById(id);
			return new Response(true);
		}catch(Exception e) {
			return new Response(false);
		}
	}
}
