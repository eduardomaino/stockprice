# stockprice
Latitude Coding Challenge

This appplication calculates the maximum profit to be made based on yesterday's stock price changes. 

It's a showcase application covering the following areas:

1. Maven configuration (dependencies/plugins)
2. Junit 5, including Mockito support and parametrized tests. 
3. Spring core, handling dependency injection and listeners. 
4. Simple console interaction. 

Improvements

Given the limited scope, the following improvements could be implemented:

1. Replacing the mock repository with one representing a real data store. 
2. Returning a response object from the business class, instead of an integer, to best handle exception flows (no array or no profit scenario).

Running

The application can be run using the following Maven goal: exec:java 
