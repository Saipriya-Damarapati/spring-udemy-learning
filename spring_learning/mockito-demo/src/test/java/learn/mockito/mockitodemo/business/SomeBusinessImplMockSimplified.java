package learn.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockSimplified {
	
	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl someBusinessImpl;

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