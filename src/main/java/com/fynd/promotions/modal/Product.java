package com.fynd.promotions.modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String category;
	private Integer inventory;
	private String arrival;
	private Integer rating;
	private String currency;
	private Double price;
	private String origin;
	private String product;
	private Double priceInINR;
	private Double promotionalPriceInINR;
	
	

}
