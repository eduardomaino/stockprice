package com.latitude.emaino.stockprice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.latitude.emaino.stockprice.config.AppConfig;

/**
 * Initializes the Spring Application context.
 */
public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(final String[] args) {

		log.info("Stock Profit App - Creating the Application Context");

		final ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		context.close();
	}

}