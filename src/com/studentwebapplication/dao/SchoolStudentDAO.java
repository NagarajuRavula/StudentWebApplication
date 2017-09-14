package com.studentwebapplication.dao;
import java.util.List;

import com.studentwebapplication.model.*;
public interface SchoolStudentDAO {

	public int save(Student std);
	public int delete(int id);
	public int update(Student std);
	public List<Student> getAllStudents();
	public Student retrieveUser(String username);
	public Student getStudentById(int id);
	public boolean isExistingStudent(String email);
	
}
