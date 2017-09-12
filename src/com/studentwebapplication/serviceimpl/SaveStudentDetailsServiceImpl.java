package com.studentwebapplication.serviceimpl;

import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.daoimpl.SchoolStudentDAOImpl;
import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.SaveStudentDetailsService;

public class SaveStudentDetailsServiceImpl implements SaveStudentDetailsService {

	public SaveStudentDetailsServiceImpl() {

	}

	public static SaveStudentDetailsServiceImpl saveStd = null;

	@Override
	public int saveStudent(Student std) {
		// TODO Auto-generated method stub

		SchoolStudentDAO studentDao = new SchoolStudentDAOImpl();
		int status = studentDao.save(std);

		return status;
	}



}
