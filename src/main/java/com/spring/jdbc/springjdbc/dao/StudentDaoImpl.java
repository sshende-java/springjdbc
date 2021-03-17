package com.spring.jdbc.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.springjdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Insert query
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Update query
	public int change(Student student) {
		
		System.out.println("updating data");
		String query = "update student set city=? where id=?";
		
		int result = this.jdbcTemplate.update(query,student.getCity(),student.getId());
		return result;

	}

	public Student getStudent(int studentId) {
	
		System.out.println("Getting data");
		String query = "select * from student where id=?";
		
		RowMapper<Student> rowMapper = new RowMapperImpl();
		
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		
		System.out.println("Getting all students:");
		String query="select * from student";
		List<Student> studlist = this.jdbcTemplate.query(query, new RowMapperImpl());
		return studlist;
		
	}

}
