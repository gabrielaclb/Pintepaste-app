package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DBAccess {
	private Timestamp ts;
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private int res;
	
	public DBAccess(String driver, String url, String usr, String pwd) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usr, pwd);
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DBAccess getConnection(PropertiesReader pReader) {
		String driver = pReader.getValue("dbDriver");
		String url = pReader.getValue("dbUrl");
		String usr = pReader.getValue("dbUser");
		String pwd = pReader.getValue("dbPassword");
		return new DBAccess(driver, url, usr, pwd);
	}
	
	public ResultSet execute(String query, Object... values) throws SQLException {
		try {
			this.pstm = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			for (int i = 0; i < values.length; i++) {
				this.pstm.setObject(i + 1, values[i]);
			}
			this.rs = this.pstm.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return this.rs;
	}
	
	public int update(String query, Object... values) throws SQLException {
		try {
			this.pstm = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			for(int i = 0; i < values.length; i++) {
				this.pstm.setObject(i + 1, values[i]);
			}
			this.res = this.pstm.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return this.res;
	}
	
	public Timestamp currentTimestamp() {
		ts = new Timestamp(System.currentTimeMillis());
		return ts;
	}
	
	public void close() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
