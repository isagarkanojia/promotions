package com.fynd.promotions.schedulers;

import com.fynd.promotions.modal.Product;
import com.fynd.promotions.repository.ProductRespository;
import com.fynd.promotions.strategies.Promotion;
import com.fynd.promotions.strategies.PromotionFactory;
import com.fynd.promotions.utils.PromotionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PromotionsScheduler {

    @Autowired
    private ProductRespository productRespository;

    @Autowired
    private PromotionFactory promotionFactory;

    @Scheduled(fixedDelay = 5000)
    void updatePromotions() {

        List<Product> list = productRespository.findAll();

        Promotion promotion = promotionFactory.getPromotion(PromotionUtils.pickRandomPromotion());

        for (Product product : list) {

            promotion.apply(product);

            log.info("Price: {} Promotional Price: {} Product: {}",product.getPrice(),product.getPromotionalPrice(),product.getProduct());

        }
    }

}
