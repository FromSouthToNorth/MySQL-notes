package demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class TestMain {
	static String driver="";
	static String url="";
	static String user="";
	static String pwd="";
	public static void init(){
		Properties param=new Properties();
		String configfile="database.properties";
		InputStream is=TestMain.class.
				getClassLoader().getResourceAsStream(configfile);
		try {
			param.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = param.getProperty("driver");
		url = param.getProperty("url");
		user = param.getProperty("user");
		pwd = param.getProperty("pwd");

	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		init();
		
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,user,pwd);
		System.out.println("�ɹ�");
		System.out.println("�������û���");
		String uName=scanner.nextLine();
		System.out.println("����������");
		String uPwd=scanner.nextLine();
		//String sql="SELECT count(*) from student where studentName='"+uName+"' and loginpwd='"+uPwd+"'";
		String sql="SELECT count(*) from student where studentName=? and loginpwd=? ";
		//Statement st=conn.createStatement();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setObject(1, uName);
		pst.setObject(2, uPwd);
		//���÷��� �˴���Ҫ�ٴ�sql
		ResultSet set = pst.executeQuery();
		set.next();
		int result=set.getInt(1);
		if(result>0)
			System.out.println("��½�ɹ�");
		else
			System.out.println("��½ʧ��");
		set.close();
		pst.close();
		conn.close();
	}

}
