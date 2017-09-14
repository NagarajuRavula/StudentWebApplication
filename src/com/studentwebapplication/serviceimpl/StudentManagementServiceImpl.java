package com.studentwebapplication.serviceimpl;

import java.util.List;
import com.studentwebapplication.servicefactory.*;

import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.daoimpl.SchoolStudentDAOImpl;
import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.StudentManagementService;

public class StudentManagementServiceImpl implements StudentManagementService {

	SchoolStudentDAO studentDao = (SchoolStudentDAO) ObjectFactory.getInstance(SchoolStudentDAOImpl.class);

	@Override
	public boolean authenticateUser(String userName, String password) {
		
		System.out.println("inside auth user");
		// retrieveUser(userName);
		boolean status=false;
		Student student=studentDao.retrieveUser(userName);
		
		if(student!=null){
		String retrievePassword=student.getPassword();
		System.out.println("outsisr auth user");
		if(retrievePassword.equals(password))
		   status= true;
		}
		return status;
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
