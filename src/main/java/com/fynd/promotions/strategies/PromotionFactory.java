package com.fynd.promotions.strategies;

import com.fynd.promotions.constants.enums.PromotionName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class PromotionFactory {

    private Map<PromotionName, Promotion> promotions;

    @Autowired
    public PromotionFactory(Set<Promotion> promotionSet) {
        createPromotions(promotionSet);
    }

    public Promotion getPromotion(PromotionName promotionName) {
        return promotions.get(promotionName);
    }

    private void createPromotions(Set<Promotion> promotionSet) {
        promotions = new HashMap<>();
        promotionSet.forEach(
                promotion -> promotions.put(promotion.getName(), promotion));
    }
}