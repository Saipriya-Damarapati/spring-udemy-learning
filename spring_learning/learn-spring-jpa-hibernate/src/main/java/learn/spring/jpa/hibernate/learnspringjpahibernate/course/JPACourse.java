package learn.spring.jpa.hibernate.learnspringjpahibernate.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "course")
public class JPACourse {

	@Id
	private long id;
	
	private String name;
	
	private String author;
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public JPACourse() {
		super();
	}

	public JPACourse(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
}