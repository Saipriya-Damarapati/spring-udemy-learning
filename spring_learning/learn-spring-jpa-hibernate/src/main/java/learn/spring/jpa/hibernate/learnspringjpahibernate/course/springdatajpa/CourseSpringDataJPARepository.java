package learn.spring.jpa.hibernate.learnspringjpahibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import learn.spring.jpa.hibernate.learnspringjpahibernate.course.pojo.JPACourse;

public interface CourseSpringDataJPARepository extends JpaRepository<JPACourse, Long> {
	
	List<JPACourse> findByAuthor(String author);
	List<JPACourse> findByName(String name);

}
