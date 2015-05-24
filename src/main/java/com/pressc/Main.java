package com.pressc;

import com.pressc.model.Person;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pressc.service.PersonService;

public class Main {
	final static Logger _log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		PersonService personService = ctx.getBean("personService", PersonService.class);

		_log.info(personService.getPerson().getName());
		personService.getPerson().setName("spock");
		_log.info(personService.getPerson().getName());

		Person e = new Person();
		e.setName("han solo");
		personService.setPerson(e);
		personService.getPerson();

		personService.foo("star wars", "star trek");
		
		ctx.close();
	}

}
