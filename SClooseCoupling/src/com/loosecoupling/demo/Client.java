package com.loosecoupling.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		
		/*Student student = new Student();
		Mathcheat cheat = new Mathcheat();
		student.setMathcheat(cheat);
		student.cheating();*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beansone.xml");
		Student student = context.getBean("student", Student.class);
		student.cheating();
		
		
	}

}
