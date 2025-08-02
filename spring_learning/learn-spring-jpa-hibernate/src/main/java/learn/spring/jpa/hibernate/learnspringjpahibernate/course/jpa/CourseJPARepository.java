package learn.spring.jpa.hibernate.learnspringjpahibernate.course.jpa;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import learn.spring.jpa.hibernate.learnspringjpahibernate.course.pojo.JPACourse;

@Repository
@Transactional
public class CourseJPARepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insertCourse(JPACourse course) {
		entityManager.merge(course);
	}
	
	public JPACourse findById(long id) {
		return entityManager.find(JPACourse.class, id);
	}
	
	public void deleteById(long id) {
		JPACourse courseToBeDeleted = entityManager.find(JPACourse.class, id);
		entityManager.remove(courseToBeDeleted);
	}
}
