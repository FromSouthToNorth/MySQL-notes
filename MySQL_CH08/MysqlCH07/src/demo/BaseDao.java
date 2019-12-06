package demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
	static String driver="";
	static String url="";
	static String user="";
	static String pwd="";
	static Connection conn=null;
	//�������ļ��ж�ȡ���ݿ����������Ϣ
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
	static{
		//������ص�ʱ���Զ�ִ�� ��ִֻ��һ��
		init();
	}
	/**
	 * ������Ӷ���
	 * @throws Exception 
	 */
	public static void getConn() throws Exception{
		Class.forName(driver);
		if(conn==null||conn.isClosed()){
			conn=DriverManager.getConnection(url,user,pwd);
		}
	}
	/**
	 * �ر���صĶ���
	 * @param conn
	 * @param st
	 * @param set
	 * @throws Exception
	 */
	public void close(Connection conn,Statement st,ResultSet set) 
			throws Exception{
		if(set!=null)
			set.close();
		if(st!=null)
			st.close();
		if(conn!=null)
			conn.close();
	}
	/**
	 * ִ����ɾ�ĵ� sql���� 
	 * @param sql
	 * @return
	 * @throws Exception 
	 */
	public int executeUpdate(String sql) throws Exception {
		getConn();
		Statement st=conn.createStatement();
		int result = st.executeUpdate(sql);
		close(conn,st,null);
		return result;
	}
	/**
	 * ִ����ɾ�� ���ǰ���? ���ע�빥����sql
	 * @param sql
	 * @param paras
	 * @return
	 * @throws Exception
	 */
	public int executeUpdate(String sql,Object[]paras) throws Exception {
		getConn();
		PreparedStatement pst=conn.prepareStatement(sql);
		//��������
		for (int i = 0; i < paras.length; i++) {
			pst.setObject(i+1, paras[i]);
		}
		int result = pst.executeUpdate();
		close(conn,pst,null);
		return result;
	}
	/**
	 * ִ�в�ѯ���sql
	 * @param sql
	 * @return
	 * @throws Exception 
	 */
	public ResultSet executeQuery(String sql) throws Exception{
		getConn();
		Statement st=conn.createStatement();
		ResultSet result = st.executeQuery(sql);
		return result;
	}
	/**
	 * ִ�����ʺŵĲ�ѯ��sql��� ���ע�빥��
	 * @param sql
	 * @param paras
	 * @return
	 * @throws Exception
	 */
	public ResultSet executeQuery(String sql,Object[]paras) throws Exception{
		getConn();
		PreparedStatement pst=conn.prepareStatement(sql);
		for (int i = 0; i < paras.length; i++) {
			pst.setObject(i+1,paras[i]);
		}
		ResultSet result = pst.executeQuery();
		return result;
	}
	
}
