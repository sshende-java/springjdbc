package com.spring.jdbc.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.springjdbc.dao.StudentDaoImpl;
import com.spring.jdbc.springjdbc.entities.Student;



public class App {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Program started....");

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		StudentDaoImpl studentDaoImpl = ctx.getBean("studentdaoimpl",StudentDaoImpl.class);
		
//		Student student = new Student();
//		student.setId(11);
//		student.setName("depp");
//		student.setCity("Delhi");
//		
//		int result = studentDaoImpl.insert(student);
//		System.out.println("student added "+result);
		
//		Student stud1 = new Student();
//		stud1.setId(11);
//		stud1.setCity("Amravati");
//		
//		int result = studentDaoImpl.change(stud1);
//		System.out.println("updated rows "+result);
		
		//to get single student
//		Student stud = studentDaoImpl.getStudent(11);
//		System.out.println(stud);
		
		//To get all students
		List<Student> studlist = studentDaoImpl.getAllStudents();
		
		for(Student s:studlist)
		{
			System.out.println(s);
		}
	}
}
