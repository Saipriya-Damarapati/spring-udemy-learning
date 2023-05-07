package programming;

import java.util.List;

public class FP06_Exercise {
	
	// print all courses individually
	// List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
	public static void main(String... args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
		printNumberOfLettersInEachCourseStructured(courses);
		printNumberOfLettersInEachCourseFunctional(courses);
	}

	private static void printNumberOfLettersInEachCourseFunctional(List<String> courses) {
		System.out.println("Using Functional approach");
		System.out.println("--------------------------------");
		courses.stream().map(course -> course + "-" + course.length()).forEach(System.out::println);
		System.out.println("--------------------------------");
	}

	private static void printNumberOfLettersInEachCourseStructured(List<String> courses) {
		System.out.println("Using Structured approach");
		System.out.println("--------------------------------");
		for(String course : courses) {
			System.out.println(course + "-" + course.length());
		}
		System.out.println("--------------------------------");
	}

}
