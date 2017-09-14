package com.studentwebapplication.serviceimpl;

import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.servicefactory.*;
import com.studentwebapplication.daoimpl.SchoolStudentDAOImpl;
import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.EditStudentDetailsService;

public class EditStudentDetailsServiceImpl  implements EditStudentDetailsService{
	
	public EditStudentDetailsServiceImpl()
	{
		
	}
	

	@Override
	public int updateStudent(Student std) {
		
		//SchoolStudentDAO studentDao=new SchoolStudentDAOImpl();
		SchoolStudentDAO studentDao=(SchoolStudentDAO)ObjectFactory.getInstance(SchoolStudentDAOImpl.class);
	   return studentDao.update(std); 
		
	}
	
	

}
