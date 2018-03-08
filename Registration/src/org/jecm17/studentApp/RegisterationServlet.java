package org.jecm17.studentApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.studentsapp.dao.StudentDAO;
import org.studentsapp.dto.StudentInfoBean;

@SuppressWarnings("serial")
public class RegisterationServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentInfoBean bean =new StudentInfoBean();
		bean.setYOP(Integer.parseInt(req.getParameter("yop")));
		//bean.setYOP(2016);
		bean.setName(req.getParameter("nm"));
		bean.setPhone(req.getParameter("ph"));
		bean.setEmail(req.getParameter("em"));
		bean.setPassword(req.getParameter("pwd"));
		bean.setIsAdmin(req.getParameter("is"));
		bean.setDegree(req.getParameter("dg"));
		//bean.setId(Integer.parseInt(req.getParameter("id")));
		bean.setId(Integer.parseInt(req.getParameter("id")));
		//bean.setId(44);
		
		
		StudentDAO dao = new StudentDAO();
		dao.insert(bean);
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("RegiSuccessfull");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
		
	}

}
