package com.ignek.student.portal.dao;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import com.ignek.student.portal.bean.Student;

public class StudentDao {
	
	//get connection
	public static Connection getConnection(){  
	    Connection connection = null;  
	    try{  
	        Class.forName("com.mysql.cj.jdbc.Driver");  
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");  
	    }
	    catch(Exception e){System.out.println(e);}  
	    return connection;  
	}
	
	//insert or update
	public static int insert(Student student)
	{
		
		int status = 0;
		try
		{
			Connection connection = getConnection();
			int id = student.getId();
			PreparedStatement preparedStatement;
			if(id == 0)
			{
				preparedStatement = connection.prepareStatement("insert into student(name,email,phone_number,birth_date,education) values(?,?,?,?,?)");		
			}
			else
			{
				preparedStatement = connection.prepareStatement("update student set name=?,email=?,phone_number=?,birth_date=?,education=? where id=?");
				preparedStatement.setInt(6, student.getId());
			}
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setString(3, student.getPhoneNumber());
			String dobString = student.getBirthDate();
			//date
			java.sql.Date birthDate = java.sql.Date.valueOf(dobString);
			preparedStatement.setDate(4, birthDate);
			preparedStatement.setString(5, student.getEducation());
			
			status = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			return status;
			
		}
		catch (Exception e) {System.out.println(e);}
		return 0;
	}

	//delete
	public static int delete(int id)
	{
		int status=0;
		try
		{
			Connection connection=getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from student where id=?");
			preparedStatement.setInt(1,id);
			
			status=preparedStatement.executeUpdate();
			return status;	
		}
		catch (Exception e) {System.out.println(e);}
		return 0;	
	}
	
	//view
	public static List<Student> viewStudents()
	{
		 List<Student> students = new ArrayList<>();
		 try
		 {
			 Connection connection=getConnection();
			 PreparedStatement preparedStatement=connection.prepareStatement("select*from student");
			 ResultSet resultSet=preparedStatement.executeQuery();
			 
			 while(resultSet.next())
			 {
				 Student student=new Student();
				 student.setId(resultSet.getInt("id"));
				 student.setEmail(resultSet.getString("email"));
				 student.setName(resultSet.getString("name"));
				 student.setPhoneNumber(resultSet.getString("phone_number"));
				 //date
				 java.sql.Date birthDate = resultSet.getDate("birth_date");
				 String birthDateString = (birthDate != null) ? birthDate.toString() : null;
				 student.setBirthDate(birthDateString);
				 student.setEducation(resultSet.getString("education"));
				 students.add(student);
				 
			 }
			 resultSet.close();
				preparedStatement.close();
				connection.close();
			 return students;
		 }
		 catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	//get student
	public static Student getStudent(int id)
	{
		Student student=new Student();
		try {
			Connection connection=getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select*from student where id=?");
			
			preparedStatement.setInt(1,id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setPhoneNumber(resultSet.getString("phone_number"));
				student.setEducation(resultSet.getString("education"));
				student.setEmail(resultSet.getString("email"));
				//date
				java.sql.Date birthDate = resultSet.getDate("birth_date");
				String birthDateString = (birthDate != null) ? birthDate.toString() : null;
				student.setBirthDate(birthDateString);
			}
			return student;
			
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
}
