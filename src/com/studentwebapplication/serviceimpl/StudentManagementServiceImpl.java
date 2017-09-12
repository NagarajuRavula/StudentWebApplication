package com.studentwebapplication.serviceimpl;

import java.util.List;

import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.daoimpl.SchoolStudentDAOImpl;
import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.StudentManagementService;

public class StudentManagementServiceImpl implements StudentManagementService {

	public static StudentManagementServiceImpl stdAuth = null;
	SchoolStudentDAO studentDao = new SchoolStudentDAOImpl();

	@Override
	public boolean isValidUser(String username, String password) {

		return studentDao.isValidStudent(username, password);
	}
/**
 * get all student detail.
 */
	@Override
	public List<Student> getAllStudents() {

		List<Student> allStudents;
		allStudents = studentDao.getAllStudents();

		return allStudents;
	}
	
	@Override
	public Student getStudentById(int id) {

		Student std;
		std = studentDao.getStudentById(id);
		return std;
	}

}
