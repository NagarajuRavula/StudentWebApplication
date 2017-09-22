package com.studentwebapplication.service.impl;

import java.util.List;

import com.studentwebapplication.beanfactory.*;
import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.dao.impl.SchoolStudentDAOImpl;
import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.StudentManagementService;

public class StudentManagementServiceImpl implements StudentManagementService {

	SchoolStudentDAO studentDao = (SchoolStudentDAO) ObjectFactory.getInstance(SchoolStudentDAOImpl.class);

	@Override
	public Student authenticateUser(String userName, String password) {
		Student student=null;
		student = studentDao.retrieveUser(userName);

		if (student != null) {
			String retrievePassword = student.getPassword();
			if (retrievePassword.equals(password))
				return student;
			else
				return null;
		}
		return student;
	}

	/**
	 * get all student detail.
	 */
	@Override
	public List<Student> getAllStudents() {

		return studentDao.getAllStudents();

	}

	@Override
	public Student getStudentById(int id) {

		return studentDao.getStudentById(id);
	}

	@Override
	public boolean isExistingStudent(String email) {

		return studentDao.isExistingStudent(email);
	}

}
