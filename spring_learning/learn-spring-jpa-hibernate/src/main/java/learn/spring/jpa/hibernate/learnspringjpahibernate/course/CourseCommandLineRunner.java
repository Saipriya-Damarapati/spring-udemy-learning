package learn.spring.jpa.hibernate.learnspringjpahibernate.course;

import learn.spring.jpa.hibernate.learnspringjpahibernate.course.pojo.JPACourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import learn.spring.jpa.hibernate.learnspringjpahibernate.course.springdatajpa.CourseSpringDataJPARepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	// JDBC CommandLineRunner
	/*
	@Autowired
	private CourseJdbcRepository jdbcRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//jdbcRepository.insertHardCodedData();
		jdbcRepository.insert(new Course(1, "Learn AWS", "com.in28minutes"));
		jdbcRepository.insert(new Course(2, "Learn Azure", "com.in28minutes"));
		jdbcRepository.insert(new Course(3, "Learn DevOps", "com.in28minutes"));
		jdbcRepository.insert(new Course(4, "Learn Angular", "com.in28minutes"));
		
		jdbcRepository.deleteById(1);
		
		//jdbcRepository.displayAllCourses().forEach(System.out::println);
		System.out.println(jdbcRepository.displayById(3).toString());
	}
	*/
	
	// JPA CommandLineRunner	
	/*
	@Autowired
	private CourseJPARepository courseJPARepository;
	
	@Override
	public void run(String... args) throws Exception {
		courseJPARepository.insertCourse(new JPACourse(1, "Learn AWS", "JPA Author"));
		courseJPARepository.insertCourse(new JPACourse(2, "Learn Azure", "JPA Author"));
		courseJPARepository.insertCourse(new JPACourse(3, "Learn DevOps", "JPA Author"));
		courseJPARepository.insertCourse(new JPACourse(4, "Learn Angular", "JPA Author"));
		
		courseJPARepository.deleteById(1);
		
		System.out.println(courseJPARepository.findById(3).toString());
		System.out.println(courseJPARepository.findById(4).toString());
	}
	*/
	
	// Spring Data JPA CommandLineRunner
	@Autowired
	private CourseSpringDataJPARepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new JPACourse(1, "Learn AWS", "Spring Data JPA Author"));
		repository.save(new JPACourse(2, "Learn Azure", "Spring Data JPA Author"));
		repository.save(new JPACourse(3, "Learn DevOps", "Spring Data JPA Author"));
		repository.save(new JPACourse(4, "Learn Angular", "Spring Data JPA Author Custom"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(3l).toString());
		System.out.println(repository.findById(4l).toString());
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("Spring Data JPA Author Custom"));
		System.out.println(repository.findByAuthor(""));
		System.out.println(repository.findByName("Learn DevOps"));
	}
}
