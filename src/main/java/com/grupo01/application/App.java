package com.grupo01.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupo01.service.HelloWorldService;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//HelloWorld obj = ctx.getBean(HelloWorld.class);
		//obj.printHello();
		//Person obj = ctx.getBean(Person.class);
		HelloWorldService world = ctx.getBean(HelloWorldService.class);
		world.printHello();
		
		//TODO Crear la ventana para el editor
	}
}
