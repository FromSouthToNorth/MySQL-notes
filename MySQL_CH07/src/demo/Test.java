package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		//�ټ���������
//		String str="sun.jdbc.odbc.JdbcOdbcDriver";
//		Class.forName(str);
//		//�ڴ������Ӷ���
//		Connection conn=DriverManager
//				.getConnection("jdbc:odbc:MySql256", "root", "899135");
	
		Scanner input=new Scanner(System.in);
		//�ټ���������
		String str="com.mysql.jdbc.Driver";
		Class.forName(str);
		//�ڴ������Ӷ���
		Connection conn=DriverManager
				.getConnection("jdbc:mysql://127.0.0.1:3306/myschool","root","899135");
		System.out.println("���ӳɹ�");
		//��дsql���
//		System.out.println("������ѧ��");
//		String stuNo=input.next();
//		System.out.println("������γ̱��");
//		String subId=input.next();
//		System.out.println("������ʱ��");
//		String date=input.next();
//		System.out.println("���������");
//		int stuRel=input.nextInt();
//		String sql="insert into result(studentNo,subjectID,examdate,studentresult) values('"+stuNo+"',"+subId+",'"+date+"',"+stuRel+")";
//		//�ܴ���ִ������
//		Statement st=conn.createStatement();
//		//�ݵ��÷���
//		int result = st.executeUpdate(sql);
//		System.out.println(result);
		
		//���ݿγ�����ģ��ɾ��ָ���Ŀγ�
//		System.out.println("������Ҫɾ���Ŀγ�����(֧��ģ��ɾ��)");
//		String subName=input.next();
//		String sql="delete from subject where subjectName like '"+subName+"%'";
//		Statement st=conn.createStatement();
//		int result = st.executeUpdate(sql);
//		if(result>0)
//			System.out.println("�Ѿ�ȫ��ɾ��");
//		else
//			System.out.println("û��ɾ����¼");
//		//�޹ر�
//		st.close();
//		conn.close();
		
		
		//��дsql���
//		String sql="select * from student";
//		//�ܴ���ִ������
//		Statement st=conn.createStatement();
//		//�ݵ��÷���
//		ResultSet set = st.executeQuery(sql);
//		//����set�ж�ȡ���� ÿ��ȡһ�� ����һ��
//		while(set.next()){
//			System.out.print(set.getObject(1)+"  ");
//			System.out.print(set.getString(2)+"  ");
//			System.out.print(set.getInt(5)+"  ");
//			System.out.println(set.getDate("borndate"));
//		}
//		System.out.println("������ѧ������");
//		String stuName=input.next();
//		System.out.println("������γ�����");
//		String subName=input.next();
//		//��ѯָ��ѧ�� ָ���γ����ƵĿ��Գɼ�
//		String sql="select studentResult,examdate from result where studentNo="
//                   +" (select studentNo from student where studentName='"+stuName+"')"
//                   +" and subjectID=(select subjectID from subject where subjectName='"+subName+"')";
//		Statement st=conn.createStatement();
//		ResultSet set = st.executeQuery(sql);
//		System.out.println("�ɼ�\t����ʱ��");
//		while(set.next()){
//			System.out.print(set.getInt(1)+"\t");
//			System.out.println(set.getDate(2));
//		}
//		set.close();
//		st.close();
//		conn.close();
		
		Menu menum=new Menu();
		menum.PrintMenu();
		
	}

}
