package com.latitude.emaino.stockprice.service.profit;

/**
 * @author Eduardo Maino
 *
 *         Responsible for calculating the maximum profit for yesterday, if any.
 */
public interface YesterdayProfitService {

	/**
	 * Calculates the maximum profit, returning an integer. In case of invalid data,
	 * it returns -1. In case of a no profit scenario, it returns -2.
	 */
	public int getMaxProfit();
}
