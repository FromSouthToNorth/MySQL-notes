package dao;

import java.util.List;

import entity.Student;

public interface StudentDAO {
	/*
	新增学生
	删除学生
	修改学生
	查询所有学生信息
	查询单个学生信息(学号)
	查询单个学生信息(姓名)
	*/
	/**
	 * 新增学生
	 * @param stu
	 * @return
	 */
	public boolean addStudent(Student stu);
	/**
	 * 删除学生
	 * @param stuNo
	 * @return
	 */
	public boolean delStudent(String stuNo);
	/**
	 * 修改学生
	 * @param stu
	 * @return
	 */
	public boolean updStudent(Student stu);
	/**
	 * 根据学号查询学生
	 * @param stuNo
	 * @return
	 */
	public Student ckStudent(String stuNo);
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> ckStudent();
}
