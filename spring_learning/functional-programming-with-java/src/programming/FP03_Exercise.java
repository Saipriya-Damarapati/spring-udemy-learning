package programming;

import java.util.List;

public class FP03_Exercise {
	
	// print all courses individually
	// List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
	public static void main(String... args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
		printCoursesContainingSpringStructured(courses);
		printCoursesContainingSpringFunctional(courses);
	}

	private static void printCoursesContainingSpringFunctional(List<String> courses) {
		System.out.println("Using Functional approach");
		System.out.println("--------------------------------");
		courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
		System.out.println("--------------------------------");
	}

	private static void printCoursesContainingSpringStructured(List<String> courses) {
		System.out.println("Using Structured approach");
		System.out.println("--------------------------------");
		for(String course : courses) {
			if(course.contains("Spring")) {
				System.out.println(course);
			}
		}
		System.out.println("--------------------------------");
	}

}
