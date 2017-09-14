package com.studentwebapplication.serviceimpl;

import java.util.List;
import com.studentwebapplication.servicefactory.*;

import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.daoimpl.SchoolStudentDAOImpl;
import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.StudentManagementService;

public class StudentManagementServiceImpl implements StudentManagementService {

	//SchoolStudentDAO studentDao = new SchoolStudentDAOImpl();
	SchoolStudentDAO studentDao = (SchoolStudentDAO) ObjectFactory.getInstance(SchoolStudentDAOImpl.class);

	@Override
	public boolean isValidUser(final String USERNAME, final String PASSWORD) {

		return studentDao.isValidStudent(USERNAME, PASSWORD);
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
