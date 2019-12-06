package dao;

import java.util.List;

import entity.Student;

public interface StudentDAO {
	/*
	����ѧ��
	ɾ��ѧ��
	�޸�ѧ��
	��ѯ����ѧ����Ϣ
	��ѯ����ѧ����Ϣ(ѧ��)
	��ѯ����ѧ����Ϣ(����)
	*/
	/**
	 * ����ѧ��
	 * @param stu
	 * @return
	 */
	public boolean addStudent(Student stu);
	/**
	 * ɾ��ѧ��
	 * @param stuNo
	 * @return
	 */
	public boolean delStudent(String stuNo);
	/**
	 * �޸�ѧ��
	 * @param stu
	 * @return
	 */
	public boolean updStudent(Student stu);
	/**
	 * ����ѧ�Ų�ѯѧ��
	 * @param stuNo
	 * @return
	 */
	public Student ckStudent(String stuNo);
	/**
	 * ��ѯ����ѧ��
	 * @return
	 */
	public List<Student> ckStudent();
}
