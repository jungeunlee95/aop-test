package com.cafe24.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	 
	public ProductVo find(String name) {
		System.out.println("[ProductService] finding ... ");
		
//		if(true) {
//			throw new RuntimeException("my exeception");
//		}
		
		return new ProductVo(name);
	}
}
