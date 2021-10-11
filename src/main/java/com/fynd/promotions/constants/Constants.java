package com.fynd.promotions.constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	
	public static Map<String,Double> currencyToINR=new HashMap<>();
	
	static {
		
		currencyToINR.put("USD", 60.0);
		currencyToINR.put("ZAR",1.2 );
		currencyToINR.put("JPY", 1.0);
		
	}
	
	

}
