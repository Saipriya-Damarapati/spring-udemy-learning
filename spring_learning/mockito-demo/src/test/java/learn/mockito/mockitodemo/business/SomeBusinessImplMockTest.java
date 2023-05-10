package learn.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SomeBusinessImplMockTest {

	DataService dataServiceMock;
	SomeBusinessImpl someBusinessImpl;
	
	@BeforeEach
	void setup() {
		dataServiceMock = mock(DataService.class);
		someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
	}

	@Test
	void testBasicScenario() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15, 25, 5, 35, 20});
		int result = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(35, result);
	}
	
	@Test
	void testOneElement() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {20});
		int result = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(20, result);
	}
	
	@Test
	void testNoElements() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int result = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(Integer.MIN_VALUE, result);
	}
}