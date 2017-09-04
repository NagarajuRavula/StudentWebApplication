package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.controller.*;

public class StudentDao {

	public static Connection getConnection() {
        Connection con=null; 

		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDB", "root", "system");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	 public static int save(Student std){  
	        int status=0;  
	        try{  
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into student(name,email,fatherName,motherName,gender,class,marks,attendence,classrank,username,password) "
	                         + "values (?,?,?,?,?,?,?,?,?,?,?)");  
	            ps.setString(1,std.getName());  
	            ps.setString(2,std.getEmail()); 
	            ps.setString(3,std.getFatherName());  
	            ps.setString(4,std.getMothername()); 
	            ps.setString(5,std.getGender());  
	            ps.setInt(6,std.getPresentClass()); 
	            ps.setDouble(7,std.getMarks()); 
	            ps.setDouble(8,std.getAttendence()); 
	            ps.setInt(9,std.getClassrank());  
	            ps.setString(10,std.getUsername());
	            ps.setString(11,std.getPassword());
	             
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    } 
	 
	 
	 
	  public static int update(Student std){  
	        int status=0;  
	        try{  
	        	System.out.println("inside update method:");
	        	System.out.println("name: "+std.getName());
	        	System.out.println("email: "+std.getEmail());
	        	System.out.println("mother name: "+std.getMothername());
	        	System.out.println("father name: "+std.getFatherName());
	        	System.out.println("gender: "+std.getGender());
	        	System.out.println("class present: "+std.getPresentClass());
	        	System.out.println("marks: "+std.getMarks());
	        	System.out.println("attendence: "+std.getAttendence());
	        	System.out.println("classrank: "+std.getClassrank());
	        	System.out.println("username: "+std.getUsername());
	        	System.out.println("password: "+std.getPassword());
	        	System.out.println("id: "+std.getId());
	        
	        	
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update student set name=?,email=?,fatherName=?,motherName=?,gender=?,class=?,marks=?,attendence=?,classrank=?,username=?,password=? where id=?");  
	            ps.setString(1,std.getName());  
	            ps.setString(2,std.getEmail());  
	            ps.setString(3,std.getFatherName());  
	            ps.setString(4,std.getMothername());  
	            ps.setString(5,std.getGender());  
	            ps.setInt(6,std.getPresentClass());  
	            ps.setDouble(7,std.getMarks());  
	            ps.setDouble(8,std.getAttendence());  
	            ps.setInt(9,std.getClassrank());  
	            ps.setString(10,std.getUsername());  
	            ps.setString(11,std.getPassword());  
	            ps.setInt(12,std.getId());  
	             
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	 
	 
	  public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from student where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	
	  
	  public static List<Student> getAllStudent(){  
	        List<Student> list=new ArrayList<Student>();  
	          
	        try{  
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from student");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Student std=new Student();  
	                std.setId(rs.getInt(1));  
	                std.setName(rs.getString(2));   
	                std.setEmail(rs.getString(3)); 
//	                std.setMothername(rs.getString(4));   
//	                std.setFatherName(rs.getString(5)); 
	                std.setFatherName(rs.getString(4));
	                std.setMothername(rs.getString(5));
	                std.setGender(rs.getString(6));   
	                std.setPresentClass(rs.getInt(7)); 
	                std.setMarks(rs.getDouble(8));   
	                std.setAttendence(rs.getDouble(9)); 
	                std.setClassrank(rs.getInt(10));   
	                std.setUsername(rs.getString(11)); 
	                std.setPassword(rs.getString(12));   
	                list.add(std);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    } 
	  
	  
	  public static boolean isValiduser(String username,String password)
	  {
		  boolean status=false;
		  try{
			  Connection con=StudentDao.getConnection();
			  PreparedStatement ps=con.prepareStatement(  
						"select * from student where username=? and password=?");  
						ps.setString(1,username);  
						ps.setString(2,password);  
						      
						ResultSet rs=ps.executeQuery();  
					status=rs.next(); 
			  
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  return status;
	  }
	  
	  
	  public static Student getStudentById(int id){  
	        Student std=new Student();  
	          
	        try{  
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from student where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	 std.setId(rs.getInt(1));  
		                std.setName(rs.getString(2));   
		                std.setEmail(rs.getString(3));
		                std.setFatherName(rs.getString(4));
		                std.setMothername(rs.getString(5));
		                std.setGender(rs.getString(6));   
		                std.setPresentClass(rs.getInt(7)); 
		                std.setMarks(rs.getDouble(8));   
		                std.setAttendence(rs.getDouble(9)); 
		                std.setClassrank(rs.getInt(10));   
		                std.setUsername(rs.getString(11)); 
		                std.setPassword(rs.getString(12));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return std;  
	    }  
	  
	  
	  
}
