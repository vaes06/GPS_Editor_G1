package com.grupo01.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.grupo01.dao.IHelloWorldRepository;
import com.grupo01.model.Person;

public class HelloWorldService implements IHelloWorldService {
	private IHelloWorldRepository helloWorldRepository;
	public void setHelloWorldRepository(IHelloWorldRepository helloWorldRepository) {
		this.helloWorldRepository = helloWorldRepository;
	}
	public HelloWorldService() {
	}
	public HelloWorldService(IHelloWorldRepository repository) {
		helloWorldRepository = repository;
	}
	public void printHello() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		Person person = helloWorldRepository.getPerson();
		if(person==null) System.out.println("Person not instances");
		System.out.println("Hello " + person.getName() + ", Its: " + formatter.format(date));
	}

}
