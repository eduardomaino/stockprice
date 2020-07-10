package com.latitude.emaino.stockprice.repository.stock;

import org.springframework.stereotype.Repository;

/**
 * @author Eduardo Maino
 *
 *         For the scope of this work, this repository is just a mock
 *         representing yesterday's data. A real implementation would fetch the
 *         data from where it is stored.
 */
@Repository
public class YesterdayStockPricesRepositoryImpl implements YesterdayStockPricesRepository {

	/*
	 * Mock data representing yesterday's scenario.
	 */
	private static int[] pricesPerMinute = { 1, 2, 3, 100, 90, 50, 40, 21, 23, 25 };

	@Override
	public int[] getYesterdayPrices() {

		return pricesPerMinute;
	}

}
