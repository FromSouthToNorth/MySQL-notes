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
	//从配置文件中读取数据库相关配置信息
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
		//在类加载的时候自动执行 且只执行一次
		init();
	}
	/**
	 * 获得连接对象
	 * @throws Exception 
	 */
	public static void getConn() throws Exception{
		Class.forName(driver);
		if(conn==null||conn.isClosed()){
			conn=DriverManager.getConnection(url,user,pwd);
		}
	}
	/**
	 * 关闭相关的对象
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
	 * 执行增删改的 sql操作 
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
	 * 执行增删改 但是包含? 解决注入攻击的sql
	 * @param sql
	 * @param paras
	 * @return
	 * @throws Exception
	 */
	public int executeUpdate(String sql,Object[]paras) throws Exception {
		getConn();
		PreparedStatement pst=conn.prepareStatement(sql);
		//参数加入
		for (int i = 0; i < paras.length; i++) {
			pst.setObject(i+1, paras[i]);
		}
		int result = pst.executeUpdate();
		close(conn,pst,null);
		return result;
	}
	/**
	 * 执行查询语句sql
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
	 * 执行有问号的查询的sql语句 解决注入攻击
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
