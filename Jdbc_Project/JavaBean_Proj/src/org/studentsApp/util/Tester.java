package org.studentsApp.util;

import org.studentsApp.dao.StudentsDAO;
import org.studentsApp.dto.StudentInfoBean;

public class Tester {

	public static void main(String[] args) {
		
		StudentInfoBean bean=new StudentInfoBean();
		bean.setId(2);
		bean.setName("deepak");
		bean.setDegree("M.Tech");
		bean.setEmail("kumbarsd@gmail.com");
		bean.setPhone("9972746641");
		bean.setYop(2016);
		bean.setPassword("prajwal");
		bean.setIsAdmin("yes");
		
		StudentsDAO dao=new StudentsDAO();
		dao.insert(bean);
	}

}
