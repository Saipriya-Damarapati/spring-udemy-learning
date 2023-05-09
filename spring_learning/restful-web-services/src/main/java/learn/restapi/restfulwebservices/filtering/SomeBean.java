package learn.restapi.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonIgnoreProperties({"field1", "field2"}) // this is at class level
public class SomeBean {
	
	private String field1;
	
	@JsonIgnore // this is at field level
	private String field2;
	private String field3;
	
	public SomeBean() {
		super();
	}
	
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	
	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
}
