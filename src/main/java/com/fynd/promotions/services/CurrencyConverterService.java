package com.fynd.promotions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fynd.promotions.constants.Constants;
import com.fynd.promotions.modal.Product;
import com.fynd.promotions.repository.ProductRespository;

@Service
public class CurrencyConverterService {

	@Autowired
	private ProductRespository productRespository;
	
	void convertToINR() {
		
		List<Product> list=productRespository.findAll();
		
		for (Product product : list) {
			
			Constants.currencyToINR.get(product.getCurrency());
			
		}
		
	
		
		
		
	}
	


}
