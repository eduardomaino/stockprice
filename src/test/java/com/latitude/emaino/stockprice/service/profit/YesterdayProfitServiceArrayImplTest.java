package com.latitude.emaino.stockprice.service.profit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.latitude.emaino.stockprice.repository.stock.YesterdayStockPricesRepository;

@ExtendWith(MockitoExtension.class)
class YesterdayProfitServiceArrayImplTest {

	private static Stream<Arguments> nonValidArrayProvider() {
		return Stream.of(Arguments.of(new int[] { 100 }, YesterdayProfitService.UNCALCULATED_VALUE),
				Arguments.of(new int[] { 0 }, YesterdayProfitService.UNCALCULATED_VALUE),
				Arguments.of(new int[] {}, YesterdayProfitService.UNCALCULATED_VALUE));
	}

	private static Stream<Arguments> validArrayProvider() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 4, 5, 10, 9, 8, 7, 6 }, 9),
				Arguments.of(new int[] { 0, 2, 3, 4, 5, 11, 11, 8, 7, 6 }, 11),
				Arguments.of(new int[] { 1000, 2000, 500, 100, 200, 200, 1000, 2000, 200, 600 }, 1900));
	}

	@InjectMocks
	private YesterdayProfitServiceArrayImpl arrayService;

	@Mock
	private YesterdayStockPricesRepository stockRepoMock;

	@ParameterizedTest(name = "{index} => array={0}, expectedMaxProfit{1}")
	@MethodSource("validArrayProvider")
	void testDistinctPricesParametrized(final int[] array, final int expectedProfit) {

		Mockito.when(stockRepoMock.getYesterdayPrices()).thenReturn(array);

		final int result = this.arrayService.getMaxProfit();

		assertEquals(expectedProfit, result);
	}

	@Test
	void testLargeArray() {

		final int[] largeArray = IntStream.iterate(1, i -> i + 2).limit(5000).toArray();

		Mockito.when(stockRepoMock.getYesterdayPrices()).thenReturn(largeArray);

		final int result = this.arrayService.getMaxProfit();

		assertEquals(9998, result);
	}

	@Test
	void testNoProfitScenario() {

		Mockito.when(stockRepoMock.getYesterdayPrices()).thenReturn(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });

		final int result = this.arrayService.getMaxProfit();

		assertEquals(-2, result);
	}

	@ParameterizedTest(name = "{index} => array={0}, expectedMaxProfit{1}")
	@MethodSource("nonValidArrayProvider")
	void testNotEnoughDataParametrized(final int[] array, final int expectedProfit) {

		Mockito.when(stockRepoMock.getYesterdayPrices()).thenReturn(array);

		final int result = this.arrayService.getMaxProfit();

		assertEquals(expectedProfit, result);
	}

	@Test
	void testSamePrices() {

		Mockito.when(stockRepoMock.getYesterdayPrices()).thenReturn(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });

		final int result = this.arrayService.getMaxProfit();

		assertEquals(0, result);
	}
}
