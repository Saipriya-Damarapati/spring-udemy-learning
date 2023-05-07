package programming;

import java.util.List;

public class FP01_Exercise {

	// Print only odd numbers from the list
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		printOddNumbersInListStructured(numbers);
		printOddNumbersInListFunctional(numbers);
	}

	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("Using Functional approach");
		numbers.stream()
				.filter(number -> number%2==1)
				.forEach(System.out::println);
	}

	private static void printOddNumbersInListStructured(List<Integer> numbers) {
		System.out.println("Using Structured approach");
		for(int number : numbers) {
			if(number%2 != 0) {
				System.out.println(number);
			}
		}
	}

}
