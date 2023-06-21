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

@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet{

	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

		int id=Integer.parseInt(httpServletRequest.getParameter("id"));
		int status=StudentDao.delete(id);
		if(status==1){
			List<Student> students=StudentDao.viewStudents();
			System.out.println(students);
			httpServletRequest.setAttribute("studentList", students);
			httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
		}
		else
		{
			String msg="Something went wrong";
			httpServletRequest.setAttribute("msg",msg);
			httpServletRequest.getRequestDispatcher("error.jsp").forward(httpServletRequest, httpServletResponse);
		}
	}
}
