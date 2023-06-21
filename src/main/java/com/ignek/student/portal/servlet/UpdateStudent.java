package com.ignek.student.portal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.student.portal.bean.Student;
import com.ignek.student.portal.dao.StudentDao;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet{
	
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
	
		int id = Integer.parseInt(httpServletRequest.getParameter("id"));
		String name = httpServletRequest.getParameter("name");
		String email = httpServletRequest.getParameter("email");
		String phoneNumber = httpServletRequest.getParameter("phoneNumber");
		String birthDateString = httpServletRequest.getParameter("birthDate");
		String education = httpServletRequest.getParameter("education");

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setPhoneNumber(phoneNumber);
		student.setBirthDate(birthDateString);
		student.setEducation(education);
			
		int status = StudentDao.insert(student);
		
		if(status == 1){
			List<Student> students = StudentDao.viewStudents();
			System.out.println(students);
			httpServletRequest.setAttribute("studentList", students);
			httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
		}
		else{
			String msg = "Something went wrong";
			httpServletRequest.setAttribute("msg", msg);
			httpServletRequest.getRequestDispatcher("error.jsp").forward(httpServletRequest, httpServletResponse);
		}
	}
}
