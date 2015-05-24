package com.pressc.service;

import com.pressc.aspect.Loggable;
import com.pressc.model.Person;

public class PersonService {

	private Person person;

	@Loggable
	public Person getPerson(){
		return this.person;
	}

	@Loggable
	public String foo(String q1, String q2) {
		return (q2 + q1).toUpperCase();
	}

	@Loggable
	public void setPerson(Person e){
		this.person =e;
	}
}
