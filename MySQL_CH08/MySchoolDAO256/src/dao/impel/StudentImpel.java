package dao.impel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.StudentDAO;
import entity.Student;

public class StudentImpel 
extends BaseDao implements StudentDAO{

	@Override
	public boolean addStudent(Student stu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delStudent(String stuNo) {
		// TODO Auto-generated method stub
		//①写sql语句
		String sql="delete from student where studentNo=?";
		//②构建数组
		Object[]objArray=new Object[1];
		objArray[0]=stuNo;
		//③调用方法
		try {
			int result = executeUpdate(sql, objArray);
			if(result>0)
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updStudent(Student stu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student ckStudent(String stuNo) {
		// TODO Auto-generated method stub
		String sql="select * from student where studentNo=?";
		Object[]objArray=new Object[1];
		objArray[0]=stuNo;
		try {
			ResultSet set = executeQuery(sql, objArray);
			set.next();
			Student stu=new Student();
			stu.setStudentNO(set.getString(1));
			stu.setStudentName(set.getString("StudentName"));
			stu.setEmail(set.getString("Email"));
			
			set.close();
			return stu;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> ckStudent() {
		// TODO Auto-generated method stub
		String sql="select * from student";
		List<Student> stuList=new ArrayList<Student>();
		try {
			ResultSet set = executeQuery(sql);
			while(set.next()){
				Student stu=new Student();
				stu.setStudentNO(set.getString(1));
				stu.setStudentName(set.getString("StudentName"));
				stu.setEmail(set.getString("Email"));
				
				stuList.add(stu);
			}
			set.close();
			return stuList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
