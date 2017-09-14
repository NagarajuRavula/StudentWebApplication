package com.studentwebapplication.service;
import java.util.List;

import com.studentwebapplication.model.*;

public interface StudentManagementService {
	/**
	 * overall
	 * @param username hghgh.
	 * @param password
	 * @return
	 */
	public boolean authenticateUser(final String USERNAME,final String PASSWORD);
	public List<Student> getAllStudents();
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudentById(int id);
	public boolean isExistingStudent(String email);
	
}
