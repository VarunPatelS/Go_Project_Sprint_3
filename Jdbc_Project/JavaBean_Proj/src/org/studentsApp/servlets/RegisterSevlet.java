package org.studentsApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.studentsApp.dao.StudentsDAO;
import org.studentsApp.dto.StudentInfoBean;

public class RegisterSevlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		StudentInfoBean bean=new StudentInfoBean();
		bean.setId(Integer.parseInt(req.getParameter("idd")) );
		bean.setName(req.getParameter("nm"));
		bean.setPhone(req.getParameter("ph"));
		bean.setEmail(req.getParameter("em"));
		bean.setDegree(req.getParameter("Degree"));
		bean.setYop(Integer.parseInt(req.getParameter("yop")));
		bean.setPassword(req.getParameter("pw"));
		bean.setIsAdmin(req.getParameter("ad"));
		
		StudentsDAO dao=new StudentsDAO();
		dao.insert(bean);
		PrintWriter out = resp.getWriter();
		out.print("<h1>Registation Successful...</h1>");
		
		
		
		
	}

}
