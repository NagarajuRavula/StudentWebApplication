package com.studentwebapplication.serviceimpl;

import com.studentwebapplication.dao.SchoolStudentDAO;
import com.studentwebapplication.daoimpl.SchoolStudentDAOImpl;
import com.studentwebapplication.model.Student;
import com.studentwebapplication.service.EditStudentDetailsService;

public class EditStudentDetailsServiceImpl  implements EditStudentDetailsService{
	
	public EditStudentDetailsServiceImpl()
	{
		
	}
	
	public static EditStudentDetailsServiceImpl editStd=null;

	@Override
	public int updateStudent(Student std) {
		
		SchoolStudentDAO studentDao=new SchoolStudentDAOImpl();
		int status=0;
	   status=studentDao.update(std); 
		
		
		return status;
	}
	
	

}
