package com.rbs.currencypay.alexa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class RateProvider {

	private static final double VOLATILITY = 0.005;
	private static final Map<String, Double> BASE_PXS = new ConcurrentHashMap<>();
	private static final Random random = new Random();
	private static final int PRECISION = 4;

	public RateProvider() {
		BASE_PXS.put("GBPUSD", 1.2477);
		BASE_PXS.put("GBPEUR", 1.1705);
		BASE_PXS.put("GBPCAD", 1.6751);
		BASE_PXS.put("GBPAUD", 1.6524);
		BASE_PXS.put("GBPJPY", 137.4516);
		BASE_PXS.put("EURUSD", 1.0659);
	}

	public BigDecimal getPrice(String baseCcy, String quotedCcy) {
		String ccyPair = baseCcy + quotedCcy;
		Double basePx = BASE_PXS.get(ccyPair);
		if (basePx == null) {
			basePx = random.nextDouble() * 10.0;
		}
		BASE_PXS.put(ccyPair, basePx);
		return BigDecimal.valueOf(basePx + (basePx * ((random.nextDouble() - 0.5) * VOLATILITY))).setScale(PRECISION,
				RoundingMode.HALF_EVEN);
	}
}
