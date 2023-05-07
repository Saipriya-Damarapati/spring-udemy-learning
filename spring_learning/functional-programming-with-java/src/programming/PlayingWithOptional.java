package programming;

import java.util.List;
import java.util.Optional;

public class PlayingWithOptional {

	public static void main(String... args) {
		List<String> fruits = List.of("apple", "banana", "mango");
		
		Optional<String> fruitStartingWithB = fruits.stream().filter(fruit -> fruit.startsWith("b")).findFirst();
		System.out.println(fruitStartingWithB);
		System.out.println(fruitStartingWithB.isEmpty());
		System.out.println(fruitStartingWithB.isPresent());
		System.out.println(fruitStartingWithB.get());
		
		Optional<String> fruitStartingWithG = fruits.stream().filter(fruit -> fruit.startsWith("g")).findFirst();
		System.out.println(fruitStartingWithG);
		System.out.println(fruitStartingWithG.isEmpty());
		System.out.println(fruitStartingWithG.isPresent());
		System.out.println(fruitStartingWithG.get()); // throws exception : java.util.NoSuchElementException: No value present
		
		Optional<String> fruit = Optional.of("banana");
		Optional<String> empty = Optional.empty();
		
		System.out.println(fruitStartingWithG == empty); // returns true
		System.out.println(fruitStartingWithB == fruit); // returns false
		System.out.println(fruitStartingWithB.get() == fruit.get()); // returns true
	}
}
