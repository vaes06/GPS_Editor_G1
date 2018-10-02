package com.grupo01.dao;

import com.grupo01.model.Person;

public class HelloWorldRepository implements IHelloWorldRepository {
	public Person getPerson() {
		Person per = new Person();
		per.setName("Grupo01");		
		return per;
	}
}
