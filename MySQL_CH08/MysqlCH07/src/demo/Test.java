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
//		//①加载驱动类
//		String str="sun.jdbc.odbc.JdbcOdbcDriver";
//		Class.forName(str);
//		//②创建连接对象
//		Connection conn=DriverManager
//				.getConnection("jdbc:odbc:MySql256", "root", "899135");
	
		Scanner input=new Scanner(System.in);
		//①加载驱动类
		String str="com.mysql.jdbc.Driver";
		Class.forName(str);
		//②创建连接对象
		Connection conn=DriverManager
				.getConnection("jdbc:mysql://127.0.0.1:3306/myschool","root","899135");
		System.out.println("连接成功");
		//③写sql语句
//		System.out.println("请输入学号");
//		String stuNo=input.next();
//		System.out.println("请输入课程编号");
//		String subId=input.next();
//		System.out.println("请输入时间");
//		String date=input.next();
//		System.out.println("请输入分数");
//		int stuRel=input.nextInt();
//		String sql="insert into result(studentNo,subjectID,examdate,studentresult) values('"+stuNo+"',"+subId+",'"+date+"',"+stuRel+")";
//		//④创建执行命令
//		Statement st=conn.createStatement();
//		//⑤调用方法
//		int result = st.executeUpdate(sql);
//		System.out.println(result);
		
		//根据课程名称模糊删除指定的课程
//		System.out.println("请输入要删除的课程名称(支持模糊删除)");
//		String subName=input.next();
//		String sql="delete from subject where subjectName like '"+subName+"%'";
//		Statement st=conn.createStatement();
//		int result = st.executeUpdate(sql);
//		if(result>0)
//			System.out.println("已经全部删除");
//		else
//			System.out.println("没有删除记录");
//		//⑥关闭
//		st.close();
//		conn.close();
		
		
		//③写sql语句
//		String sql="select * from student";
//		//④创建执行命令
//		Statement st=conn.createStatement();
//		//⑤调用方法
//		ResultSet set = st.executeQuery(sql);
//		//调用set中读取方法 每读取一次 返回一行
//		while(set.next()){
//			System.out.print(set.getObject(1)+"  ");
//			System.out.print(set.getString(2)+"  ");
//			System.out.print(set.getInt(5)+"  ");
//			System.out.println(set.getDate("borndate"));
//		}
//		System.out.println("请输入学生姓名");
//		String stuName=input.next();
//		System.out.println("请输入课程名称");
//		String subName=input.next();
//		//查询指定学生 指定课程名称的考试成绩
//		String sql="select studentResult,examdate from result where studentNo="
//                   +" (select studentNo from student where studentName='"+stuName+"')"
//                   +" and subjectID=(select subjectID from subject where subjectName='"+subName+"')";
//		Statement st=conn.createStatement();
//		ResultSet set = st.executeQuery(sql);
//		System.out.println("成绩\t考试时间");
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
