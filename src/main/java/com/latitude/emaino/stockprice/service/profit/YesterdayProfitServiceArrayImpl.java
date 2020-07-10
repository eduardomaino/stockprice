package com.latitude.emaino.stockprice.service.profit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latitude.emaino.stockprice.repository.stock.YesterdayStockPricesRepository;

/**
 * @author Eduardo Maino
 *
 *         Implementation of the {@link YesterdayProfitService} using an array
 *         iteration strategy.
 */
@Service
public class YesterdayProfitServiceArrayImpl implements YesterdayProfitService {

	private final YesterdayStockPricesRepository yesterdayStockRepo;

	@Autowired
	public YesterdayProfitServiceArrayImpl(final YesterdayStockPricesRepository yesterdayStockRepo) {
		super();
		this.yesterdayStockRepo = yesterdayStockRepo;
	}

	@Override
	public int getMaxProfit() {

		int maxProfit = UNCALCULATED_VALUE;
		final int[] stockPrices = this.yesterdayStockRepo.getYesterdayPrices();

		if (this.isValidSizedArray(stockPrices)) {

			final int dataLength = stockPrices.length;
			int currentMaxStockValue = stockPrices[dataLength - 1];

			// Iterates the array from the end. keeping track of the highest stock price.
			for (int i = dataLength - 2; i >= 0; i--) {

				// Updates the current max value if the element is higher.
				if (stockPrices[i] > currentMaxStockValue) {
					currentMaxStockValue = stockPrices[i];
				} else {
					maxProfit = Integer.max(maxProfit, currentMaxStockValue - stockPrices[i]);
				}
			}

			// If, after going through all values we have still no maxProfit, return a NO
			// PROFIT SCENARIO.
			if (maxProfit == UNCALCULATED_VALUE) {
				maxProfit = NO_PROFIT_SCENARIO;
			}
		}

		return maxProfit;
	}
}
