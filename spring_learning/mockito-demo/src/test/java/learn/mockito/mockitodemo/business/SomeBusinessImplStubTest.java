package learn.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void test_Many_Elements() {
		DataService dataServiceImpl = new DataServiceImpl_1();
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceImpl);
		int result = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(35, result);
	}
	
	@Test
	void test_Single_Element() {
		DataService dataServiceImpl = new DataServiceImpl_2();
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceImpl);
		int result = someBusinessImpl.findTheGreatestFromAllData();
		assertEquals(15, result);
	}
}

class DataServiceImpl_1 implements DataService {
	
	@Override
	public int[] retrieveAllData() {
		return new int[] {15, 25, 5, 35, 20};
	}
}

class DataServiceImpl_2 implements DataService {
	
	@Override
	public int[] retrieveAllData() {
		return new int[] {15};
	}
}