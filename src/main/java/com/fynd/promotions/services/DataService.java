package com.fynd.promotions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fynd.promotions.modal.Product;
import com.fynd.promotions.repository.ProductRespository;

@Service
public class DataService {

	@Autowired(required = true)
	private RestTemplate restTemplate;

	@Autowired
	private ProductRespository productRespository;
	
	public void getData() {

		String URL = "https://api.jsonbin.io/b/5d31a1c4536bb970455172ca/latest";

		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});

		List<Product> list = responseEntity.getBody();


		for (Product p : list) {
			System.out.println(p);
		}

		productRespository.saveAll(list);
		
		
	}

}
