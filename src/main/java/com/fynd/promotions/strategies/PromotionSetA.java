package com.fynd.promotions.strategies;

import com.fynd.promotions.constants.enums.PromotionName;
import com.fynd.promotions.modal.Product;
import com.fynd.promotions.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PromotionSetA extends Promotion {

    @Autowired
    void setProductRepository(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @Override
    public void apply(Product product) {

        Double price = product.getPrice();

        Double maxDiscount = 0D;

        if (Objects.equals(product.getOrigin(), "Africa")) {
            Math.max(maxDiscount, calculateDiscount(price, 7));
        }

        if (product.getRating() == 2) {
            Math.max(maxDiscount, calculateDiscount(price, 4));
        }

        if (product.getRating() < 2) {
            Math.max(maxDiscount, calculateDiscount(price, 8));
        }

        if (Objects.equals(maxDiscount, 0D)) {
            applyDefaultPromotion(product);
        } else {
            product.setPromotionalPrice(price - maxDiscount);
        }

        productRespository.save(product);

    }

    @Override
    public PromotionName getName() {
        return PromotionName.PromotionSetA;
    }
}