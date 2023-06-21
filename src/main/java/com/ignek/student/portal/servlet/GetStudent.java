package com.ignek.student.portal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignek.student.portal.bean.Student;
import com.ignek.student.portal.dao.StudentDao;

@WebServlet("/getStudent")
public class GetStudent extends HttpServlet{
	
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
	  
		int id = Integer.parseInt(httpServletRequest.getParameter("id"));
		if(id == 0)
		{
			Student student = new Student();
			student.setId(id);
			httpServletRequest.setAttribute("student", student);
			httpServletRequest.getRequestDispatcher("edit.jsp").forward(httpServletRequest, httpServletResponse);
		}
		else
		{
			Student student = StudentDao.getStudent(id);
			httpServletRequest.setAttribute("student", student);
			httpServletRequest.getRequestDispatcher("edit.jsp").forward(httpServletRequest, httpServletResponse);
		}
	}
}
