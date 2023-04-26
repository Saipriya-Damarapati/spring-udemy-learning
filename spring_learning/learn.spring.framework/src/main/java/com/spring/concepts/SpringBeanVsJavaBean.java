package com.spring.concepts;

import java.io.Serializable;

class Pojo {
	private String text;
	private int number;

	public String toString() {
		return "Pojo [text=" + text + ", number=" + number + "]";
	}
}

class JavaBean implements Serializable { // EJB
	// Java Beans should always implements Serializable.

	private String text;
	private int number;

	// JavaBeans will always have public no argument constructor
	public JavaBean() {
		
	}
	
	// JavaBeans should always have getters and setters
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}

public class SpringBeanVsJavaBean {

}
