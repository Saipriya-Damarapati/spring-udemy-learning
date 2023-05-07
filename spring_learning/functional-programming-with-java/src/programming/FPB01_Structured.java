package programming;

import java.util.List;

public class FPB01_Structured {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		//printAllNumbersInListStructured(numbers);
		printEvenNumbersInListStructured(numbers);
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		// How to loop the numbers? Traditional for loop or enhanced for loop
		// let us here prefer enhanced for loop
		for(int number : numbers) {
			System.out.println(number);
		}
	}
	
	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		// How to loop the numbers? Traditional for loop or enhanced for loop
		// let us here prefer enhanced for loop
		for(int number : numbers) {
			if(number % 2 == 0) {
				System.out.println(number);
			}
		}
	}

}
