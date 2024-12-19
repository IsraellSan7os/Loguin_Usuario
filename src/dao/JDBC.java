package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	private Connection con;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/usuario";
	private String user = "root";
	private String password = "147852";
	
	public Connection conectar() {
		
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url,user,password);
		return con;
	} catch (Exception erro) {
			System.out.println(erro);
		}
	
	return null;

	}
}