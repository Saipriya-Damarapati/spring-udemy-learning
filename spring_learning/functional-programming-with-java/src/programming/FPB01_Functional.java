package programming;

import java.util.List;

public class FPB01_Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		//printAllNumbersInListStructured(numbers);
		printEvenNumbersInListStructured(numbers);
	}
	
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		// Convert the list of numbers into stream of numbers
		// Focus on what to do?
		numbers.stream().forEach(System.out::println);
	}
	
	private static boolean isEven(int number) {
		return number % 2 == 0;
	}
	
	// number is the parameter -> function body - number % 2 == 0
	// by default, if single statement is present, then that value is returned
	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		// How to loop the numbers? Traditional for loop or enhanced for loop
		// let us here prefer enhanced for loop
		numbers.stream()
			.filter(number -> number%2 == 0) // Lambda Expression
			.forEach(System.out::println); // Method Reference
		
		//.filter(FP01Functional :: isEven) // filter - only allow even numbers
	}

}
