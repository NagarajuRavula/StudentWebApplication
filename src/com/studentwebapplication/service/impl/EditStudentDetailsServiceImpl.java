package com.studentwebapplication.service.impl;

import com.studentwebapplication.beanfactory.*;
import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.dao.impl.SchoolStudentDAOImpl;
import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.EditStudentDetailsService;

public class EditStudentDetailsServiceImpl implements EditStudentDetailsService {

	public EditStudentDetailsServiceImpl() {

	}

	@Override
	public int updateStudent(Student std) {

		SchoolStudentDAO studentDao = (SchoolStudentDAO) ObjectFactory.getInstance(SchoolStudentDAOImpl.class);
		return studentDao.update(std);

	}

}
