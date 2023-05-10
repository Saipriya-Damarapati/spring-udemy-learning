package learn.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math = new MyMath();
	
	@Test
	void test() {
		// Absence of failure is a success test case
	}
	
	@Test
	void calculateSumTestNoElementArray() {
		assertEquals(0, math.calculateSum(new int[] {}));
	}
	
	@Test
	void calculateSum_ThreeMemberArray() {
		assertEquals(6, math.calculateSum(new int[] {1, 2, 3}));
	}

}
