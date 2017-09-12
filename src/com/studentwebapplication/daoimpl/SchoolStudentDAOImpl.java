package com.studentwebapplication.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentwebapplication.dao.*;
import com.studentwebapplication.model.Student;

public class SchoolStudentDAOImpl implements SchoolStudentDAO {

	@Override
	public int save(Student std) {
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = null;

		int status = 0;
		try {

			ps = con.prepareStatement(
					"insert into student(name,email,fatherName,motherName,gender,class,marks,attendence,classrank,username,password) "
							+ "values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, std.getName());
			ps.setString(2, std.getEmail());
			ps.setString(3, std.getFatherName());
			ps.setString(4, std.getMothername());
			ps.setString(5, std.getGender());
			ps.setInt(6, std.getPresentClass());
			ps.setDouble(7, std.getMarks());
			ps.setDouble(8, std.getAttendence());
			ps.setInt(9, std.getClassrank());
			ps.setString(10, std.getUsername());
			ps.setString(11, std.getPassword());

			status = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		return status;

	}

	@Override
	public int delete(int id) {

		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = null;
		int status = 0;
		try {
			ps = con.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		return status;
	}

	@Override
	public int update(Student std) {

		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = null;

		int status = 0;
		try {
			ps = con.prepareStatement(
					"update student set name=?,email=?,fatherName=?,motherName=?,gender=?,class=?,marks=?,attendence=?,classrank=?,username=?,password=? where id=?");
			ps.setString(1, std.getName());
			ps.setString(2, std.getEmail());
			ps.setString(3, std.getFatherName());
			ps.setString(4, std.getMothername());
			ps.setString(5, std.getGender());
			ps.setInt(6, std.getPresentClass());
			ps.setDouble(7, std.getMarks());
			ps.setDouble(8, std.getAttendence());
			ps.setInt(9, std.getClassrank());
			ps.setString(10, std.getUsername());
			ps.setString(11, std.getPassword());
			ps.setInt(12, std.getId());
			status = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		return status;
	}

	@Override
	public List<Student> getAllStudents() {

		List<Student> list = new ArrayList<Student>();
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from student");
			rs = ps.executeQuery();
			while (rs.next()) {
				Student std = new Student();
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
				list.add(std);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();

			} catch (Exception e) {
				System.err.println(e);
			}
		}

		return list;
	}

	@Override
	public Student getStudentById(int id) {

		Student std = new Student();
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = con.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
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

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		return std;
	}

	@Override
	public boolean isValidStudent(String username, String password) {
		boolean status = false;
		int studentid = 0;
		PreparedStatement ps = null;
		Connection con = ConnectionUtils.getConnection();
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from student where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			status = rs.next();
			if (status) {
				studentid = rs.getInt(1);

			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}

		return status;
	}

}