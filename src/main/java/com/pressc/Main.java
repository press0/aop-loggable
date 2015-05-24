package com.pressc;

import com.pressc.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pressc.service.PersonService;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		PersonService personService = ctx.getBean("personService", PersonService.class);
		
		System.out.println(personService.getPerson().getName());
		personService.getPerson().setName("spock");
		System.out.println(personService.getPerson().getName());

		Person e = new Person();
		e.setName("han solo");
		personService.setPerson(e);
		personService.getPerson();

		personService.foo("star wars", "star trek");
		
		ctx.close();
	}

}
