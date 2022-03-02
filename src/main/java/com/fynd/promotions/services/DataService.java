package com.fynd.promotions.services;

import java.util.List;

import com.fynd.promotions.constants.PromotionConstants;
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
        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(PromotionConstants.API_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });

        List<Product> list = responseEntity.getBody();
        productRespository.saveAll(list);
    }

}
