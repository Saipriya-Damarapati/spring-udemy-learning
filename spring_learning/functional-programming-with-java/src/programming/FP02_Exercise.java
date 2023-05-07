package programming;

import java.util.List;

public class FP02_Exercise {
	
	// print all courses individually
	// List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
	public static void main(String... args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
		printAllCoursesStructured(courses);
		printAllCoursesFunctional(courses);
	}

	private static void printAllCoursesFunctional(List<String> courses) {
		System.out.println("Using Functional approach");
		System.out.println("--------------------------------");
		courses.stream().forEach(System.out::println);
		System.out.println("--------------------------------");
	}

	private static void printAllCoursesStructured(List<String> courses) {
		System.out.println("Using Structured approach");
		System.out.println("--------------------------------");
		for(String course : courses) {
			System.out.println(course);
		}
		System.out.println("--------------------------------");
	}

}
