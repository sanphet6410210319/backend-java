package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
public class ProductController {
	
	private List<Product> data = new ArrayList<Product>();
	
	@GetMapping("/product")
	public List<Product> getProduct(){
		return data;
	}
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product body) {
		for(int i =0; i < data.size();i++) {
			if(body.getProductId() == data.get(i).getProductId()) {
		}
	}
		data.add(body);
		return body;
	}
	@GetMapping("/product/{productId}")
	public Product getProductDetailProduct(@PathVariable Integer ProductId) {
		System.out.println("ProductId = "+ProductId);
		for(int i=0;i<data.size();i++) {
			if (ProductId == data.get(i).getProductId()){
				return data.get(i);
			}
		}
		return null;
	}
		@PutMapping("product/{productId}")
		public Product updateProduct(@PathVariable Integer productId , @RequestBody Product body) {
			for(int i=0; i < data.size(); i++) {
				if (productId == data.get(i).getProductId()) {
					data.get(i).setProductName(body.getProductName());
					data.get(i).setProductPrice(body.getProductPrice());
					data.get(i).setProductAmount(body.getProductAmount());
					data.get(i).setProductDetail(body.getProductDetail());
					return data.get(i);


				}
			}
			return null;
		}
		@DeleteMapping("product/{productId}")
		public String deletProduct (@PathVariable Integer productId) {
			for(int i=0; i < data.size(); i++) {
				if (productId == data.get(i).getProductId()) {
					data.remove(i);
					return "delete sucess";

				}
				}
			return "employee not found";

			
		}
		@GetMapping("product/search")
		public List<Product> searchProduct(@RequestParam String productName) {
			ArrayList<Product> searchData = new ArrayList<Product>();
			for(int i=0;i<data.size();i++) {
				if (data.get(i).getProductName().contains(productName) || (data.get(i).getProductDetail().contains(productName))) {
					searchData.add(data.get(i));
				}
				
			}return searchData;
			
		}
		}
