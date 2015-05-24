package com.pressc.model;

public class Person {

	private String name;
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}

	//@Loggable
	public void setName(String nm) {
		this.name=nm;
	}

}
