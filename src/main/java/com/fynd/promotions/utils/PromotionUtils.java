package com.fynd.promotions.utils;

import com.fynd.promotions.constants.enums.PromotionName;

import java.util.Random;

public class PromotionUtils {

    public static PromotionName pickRandomPromotion() {

        int pick = new Random().nextInt(PromotionName.values().length);

        return PromotionName.PromotionSetA.values()[pick];

    }

    public static Double calculateDiscount(double price, double percentage) {

        return (percentage / 100) * price;

    }
}
