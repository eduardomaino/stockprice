package com.latitude.emaino.stockprice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring uses this class to handle its configuration, including which packages
 * will get scanned for components.
 */
@Configuration
@ComponentScan(basePackages = "com.latitude.emaino.stockprice")
public class AppConfig {

}
