package com.fynd.promotions.schedulers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fynd.promotions.modal.Product;
import com.fynd.promotions.repository.ProductRespository;

@Service
public class PromotionsScheduler {
	
	@Autowired
	private ProductRespository productRespository;
	
	@Scheduled(fixedDelay = 1000)
	void updatePromotions() {
		
		List<Product> list=productRespository.findAll();
		
		
		System.out.println(list);
	}

}
