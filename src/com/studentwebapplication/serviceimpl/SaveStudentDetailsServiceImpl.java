package com.studentwebapplication.serviceimpl;

import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.servicefactory.*;
import com.studentwebapplication.daoimpl.SchoolStudentDAOImpl;
import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.SaveStudentDetailsService;

public class SaveStudentDetailsServiceImpl implements SaveStudentDetailsService {

	public SaveStudentDetailsServiceImpl() {

	}

	@Override
	public int saveStudent(Student std) {
		// TODO Auto-generated method stub

		// SchoolStudentDAO studentDao = new SchoolStudentDAOImpl();
		SchoolStudentDAO studentDao = (SchoolStudentDAO) ObjectFactory.getInstance(SchoolStudentDAOImpl.class);
		return studentDao.save(std);
	}

}
