package com.fynd.promotions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fynd.promotions.modal.Product;

@Repository
public interface ProductRespository extends JpaRepository<Product,Integer> {

}
