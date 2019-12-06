package entity;

import java.util.Date;

public class Student {
	private String StudentNO;
	private String StudentName;
	private String LoginPwd;
	private String Sex;
	private int GradeID;
	private String Phone;
	private String Address;
	private Date BornDate;
	private String Email;
	private String IndentityCard;
	public String getStudentNO() {
		return StudentNO;
	}
	public void setStudentNO(String studentNO) {
		StudentNO = studentNO;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getLoginPwd() {
		return LoginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public int getGradeID() {
		return GradeID;
	}
	public void setGradeID(int gradeID) {
		GradeID = gradeID;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Date getBornDate() {
		return BornDate;
	}
	public void setBornDate(Date bornDate) {
		BornDate = bornDate;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getIndentityCard() {
		return IndentityCard;
	}
	public void setIndentityCard(String indentityCard) {
		IndentityCard = indentityCard;
	}
	public Student(String studentNO, String studentName, String loginPwd,
			String sex, int gradeID, String phone, String address,
			Date bornDate, String email, String indentityCard) {
		super();
		StudentNO = studentNO;
		StudentName = studentName;
		LoginPwd = loginPwd;
		Sex = sex;
		GradeID = gradeID;
		Phone = phone;
		Address = address;
		BornDate = bornDate;
		Email = email;
		IndentityCard = indentityCard;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
