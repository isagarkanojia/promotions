package com.fynd.promotions.utils;

import com.fynd.promotions.modal.Product;

import java.util.Objects;

public class CurrencyConverter {

    // constants to define currencies
    public static final String US_DOLLAR = "USD";
    public static final String JAPANESE_YEN = "JPY";
    public static final String SOUTH_AFRICAN_RAND = "ZAR";
    public static final String INDIAN_RUPE = "INR";

    // conversion rates from INR to the other currencies
    public static final double INR_TO_JAPANESE_YEN = 1.53d;
    public static final double INR_TO_SOUTH_AFRICAN_RAND = 0.20d;
    public static final double INR_TO_US_DOLLAR = 0.013d;

    public static double toINR(double amount, String otherCurrency) {
        switch (otherCurrency) {
            case INDIAN_RUPE:
                return amount;
            case JAPANESE_YEN:
                return amount / INR_TO_JAPANESE_YEN;
            case SOUTH_AFRICAN_RAND:
                return amount / INR_TO_SOUTH_AFRICAN_RAND;
            case US_DOLLAR:
                return amount / INR_TO_US_DOLLAR;
            default:
                return -1.d;
        }
    }

}
