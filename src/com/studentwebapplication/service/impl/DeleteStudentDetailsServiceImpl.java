package com.studentwebapplication.service.impl;

import com.studentwebapplication.beanfactory.*;
import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.dao.impl.SchoolStudentDAOImpl;
import com.studentwebapplication.service.*;

public class DeleteStudentDetailsServiceImpl implements DeleteStudentDetailsService {

	public DeleteStudentDetailsServiceImpl() {

	}

	public static DeleteStudentDetailsServiceImpl deleteStd = null;

	@Override
	public int deleteStudent(int id) {
		// SchoolStudentDAO studentDao=new SchoolStudentDAOImpl();
		SchoolStudentDAO studentDao = (SchoolStudentDAO) ObjectFactory.getInstance(SchoolStudentDAOImpl.class);

		return studentDao.delete(id);

	}

}
