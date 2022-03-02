package com.fynd.promotions.strategies;

import com.fynd.promotions.constants.PromotionConstants;
import com.fynd.promotions.constants.enums.PromotionName;
import com.fynd.promotions.modal.Product;
import com.fynd.promotions.repository.ProductRespository;
import com.fynd.promotions.utils.CurrencyConverter;
import com.fynd.promotions.utils.PromotionUtils;

public abstract class Promotion {

    public ProductRespository productRespository;

    public abstract void apply(Product product);

    public abstract PromotionName getName();

    protected Product applyDefaultPromotion(Product product) {

        Double price = CurrencyConverter.toINR(product.getPrice(), product.getCurrency());

        if (price > PromotionConstants.DEFAULT_AMOUNT_FOR_DISCOUNT.doubleValue()) {

            Double promotionalPrice = calculateDiscount(price, PromotionConstants.DEFAUL_DISCOUNT_PERCENTAGE);

            product.setPromotionalPriceInINR(price - promotionalPrice);

            return product;
        }

        return product;
    }

    protected Double calculateDiscount(double price, double percentage) {
        return PromotionUtils.calculateDiscount(price, percentage);
    }
}