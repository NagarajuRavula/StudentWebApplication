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
	public boolean isValidUser(String username,String password);
	public List<Student> getAllStudents();
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudentById(int id);
	
}
