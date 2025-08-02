package learn.spring.jpa.hibernate.learnspringjpahibernate.course.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import learn.spring.jpa.hibernate.learnspringjpahibernate.course.pojo.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	// Step 05 : Inserting hardcoded data using Spring JDBC
	private static String HARDCODED_INSERT_QUERY = """ 
				INSERT INTO course
				VALUES (1, 'Learn AWS', 'com.in28minutes');
		""";
	
	// Step 06 : Inserting and deleting data using Spring JDBC 
	private static String INSERT_QUERY = """ 
			INSERT INTO course
			VALUES (?, ?, ?);
	""";
	// Step 06 : Inserting and deleting data using Spring JDBC	
	private static String DELETE_QUERY = """ 
			DELETE FROM course
			WHERE id = ?;
	""";
	// Step 07 : Querying data using Spring JDBC
	private static String SELECT_QUERY = """ 
			SELECT * FROM course;
	""";
	// Step 07 : Querying data using Spring JDBC
	private static String SELECT_QUERY_BY_ID = """ 
			SELECT * FROM course
			where id = ?;
	""";
	
	public void insertHardCodedData() {
		System.out.println("Firing insert query");
		springJdbcTemplate.update(HARDCODED_INSERT_QUERY);
		System.out.println("Completed execution of insert query");
	}
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long courseId) {
		springJdbcTemplate.update(DELETE_QUERY, courseId);
	}
	
	public List<Course> displayAllCourses() {
		return springJdbcTemplate.query(SELECT_QUERY, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Course(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		});
	}
	
	public Course displayById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY_BY_ID, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
