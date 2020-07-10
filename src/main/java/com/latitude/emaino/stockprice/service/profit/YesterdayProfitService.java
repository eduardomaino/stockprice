package com.latitude.emaino.stockprice.service.profit;

/**
 * @author Eduardo Maino
 *
 *         Responsible for calculating the maximum profit for yesterday, if any.
 */
public interface YesterdayProfitService {

	public static final int NO_PROFIT_SCENARIO = -2;

	public static final int UNCALCULATED_VALUE = -1;

	/**
	 * Calculates the maximum profit, returning an integer. In case of invalid data,
	 * it returns -1. In case of a no profit scenario, it returns -2.
	 */
	public int getMaxProfit();

	default boolean isValidSizedArray(final int[] array) {

		return array.length > 1;
	}
}
