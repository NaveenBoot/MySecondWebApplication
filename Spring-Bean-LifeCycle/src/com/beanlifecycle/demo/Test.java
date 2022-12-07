/*package com.beanlifecycle.demo;

import java.sql.SQLException;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		StudentDAO obj = new StudentDAO();
		obj.selectAllRows();
		obj.deleteRow(1);
	}

}*/


package com.beanlifecycle.demo;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beansone.xml");
		StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);
		studentDAO.selectAllRows();
		((ClassPathXmlApplicationContext)context).close();
	}

}

