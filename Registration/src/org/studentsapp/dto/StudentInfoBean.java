package org.studentsapp.dto;

public class StudentInfoBean {

	private String Name;
	private int Id;
	private String Email;
	private String Phone;
	private String Degree;
	private int YOP;
	private String Password;
	private String IsAdmin;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getDegree() {
		return Degree;
	}
	public void setDegree(String degree) {
		Degree = degree;
	}
	public int getYOP() {
		return YOP;
	}
	public void setYOP(int yop) {
		YOP = yop;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		IsAdmin = isAdmin;
	}
	


}
