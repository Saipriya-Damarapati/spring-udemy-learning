package programming;

import java.util.List;

public class FPB02_Practice {

	// Print squares of even numbers from the list
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		printSquaresOfEvenNumbersInListStructured(numbers);
		printSquaresOfEvenNumbersInListFunctional(numbers);
	}

	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("Using Functional approach");
		numbers.stream()
				.filter(number -> number%2==0)
				.map(number -> number * number) // mapping, take each element and map it to its square
				.forEach(System.out::println);
	}

	private static void printSquaresOfEvenNumbersInListStructured(List<Integer> numbers) {
		System.out.println("Using Structured approach");
		for(int number : numbers) {
			if(number%2 == 0) {
				System.out.println(number * number);
			}
		}
	}
}
