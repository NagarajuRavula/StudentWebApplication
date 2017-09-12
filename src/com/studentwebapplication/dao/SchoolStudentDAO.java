package com.studentwebapplication.dao;
import java.util.List;

import com.studentwebapplication.model.*;
public interface SchoolStudentDAO {

	public int save(Student std);
	public int delete(int id);
	public int update(Student std);
	public List<Student> getAllStudents();
	public boolean isValidStudent(String username,String password);
	public Student getStudentById(int id);
	
}
