package org.studentsApp.servlets;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hits")
public class HitsServlet  extends HttpServlet{
	static int count = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		count++;
		out.print("<head>");
		out.print("<body>");
		out.print("<h1>");
		out.print(count);
		out.print("</h1>");
		out.print("</body>");
		out.print("</head>");
	}

	@Override
	public void init() throws ServletException 
	{
		FileReader fr;
		try {
			fr=new FileReader("E://java//javaprogram//MyJavaFloder/count.txt");
			count=fr.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void destroy() {
		
			FileWriter fw;
			try {
				fw = new FileWriter("E://java//javaprogram//MyJavaFloder/count.txt");
			
			fw.write(count);
			fw.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}


	

}
