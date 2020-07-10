package com.latitude.emaino.stockprice.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.latitude.emaino.stockprice.service.profit.YesterdayProfitService;

@Component
public class ApplicationConsole implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(ApplicationConsole.class);

	private static final int OPTION_ARRAY = 1;

	@Autowired
	private YesterdayProfitService profitServiceArrayStrategy;

	private String getFeedbackMessage(final int maxProfit) {

		String message;

		if (maxProfit == YesterdayProfitService.UNCALCULATED_VALUE) {

			message = String.format("Not enought data points to calculate.");

		} else if (maxProfit == YesterdayProfitService.NO_PROFIT_SCENARIO) {

			message = String.format("There's no possible profit for the current scenario.");

		} else {

			message = String.format("The maximum profit for yesterday is: %d", maxProfit);
		}

		return message;
	}

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {

		log.info("Container ready for use. Starting application console.");

		final Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("\n\nCalculate Yesterday's Best Profit. Select your option:");
			System.out.println("1 - Using an Array Iteration Strategy:");
			System.out.println("2 - exit application");

			final int option = scanner.nextInt();
			int maxProfit;

			scanner.nextLine();

			if (OPTION_ARRAY == option) {

				maxProfit = this.profitServiceArrayStrategy.getMaxProfit();

				System.out.println(this.getFeedbackMessage(maxProfit));

			} else {

				log.info("Exiting application console. Have a nice day!");

				scanner.close();
				System.exit(0);
			}
		}
	}

}
