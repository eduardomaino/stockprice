package com.latitude.emaino.stockprice.repository.stock;

/**
 * @author Eduardo Maino
 *
 *         Repository for getting yesterday stock prices.
 */
public interface YesterdayStockPricesRepository {

	/**
	 * Fethes an array representing yesterday's stock prices. Each item in the array
	 * is the price for the stock in that minute.
	 *
	 * @return An int array with the stock prices for each minute.
	 */
	public int[] getYesterdayPrices();
}
