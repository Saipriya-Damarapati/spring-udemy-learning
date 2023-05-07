package programming;

import java.util.List;

public class FP04_Exercise {
	
	// print all courses individually
	// List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
	public static void main(String... args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
		printCoursesContainingAtleast4LettersStructured(courses);
		printCoursesContainingAtleast4LettersFunctional(courses);
	}

	private static void printCoursesContainingAtleast4LettersFunctional(List<String> courses) {
		System.out.println("Using Functional approach");
		System.out.println("--------------------------------");
		courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);
		System.out.println("--------------------------------");
	}

	private static void printCoursesContainingAtleast4LettersStructured(List<String> courses) {
		System.out.println("Using Structured approach");
		System.out.println("--------------------------------");
		for(String course : courses) {
			if(course.length() >= 4) {
				System.out.println(course);
			}
		}
		System.out.println("--------------------------------");
	}

}
