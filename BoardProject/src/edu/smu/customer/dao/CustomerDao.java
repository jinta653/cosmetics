package edu.smu.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.smu.customer.vo.Customer;

public class CustomerDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//1
	}
	public Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection conn=DriverManager.getConnection(url, "scott", "tiger");
		return conn;
	}
	
	public void save(Customer c) throws SQLException {
		Connection con=getConnection();//2
		String sql="Insert into customer(email, password, name, birth, gender, telnum) "
				+ "values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setString(1, c.getEmail());
		ps.setString(2, c.getPassword());
		ps.setString(3, c.getName());
		ps.setString(4, c.getBirth());
		ps.setString(5, c.getGender());
		ps.setInt(6, c.getTelNum());
		
		ps.executeUpdate();//4
		
		ps.close();
		con.close();
	}
	
	
	public void update(Customer c) throws SQLException {
	      Connection con = getConnection();
	      String sql = "Update Customer Set PASSWORD=?, NAME=?, BIRTH=?, GENDER=?, TELNUM=? "
	            +  "where EMAIL=?";
	      PreparedStatement ps = con.prepareStatement(sql);
	      ps.setString(1, c.getPassword());
	      ps.setString(2, c.getName());
	      ps.setString(3, c.getBirth());
	      ps.setString(4, c.getGender());
	      ps.setInt(5, c.getTelNum());
	      ps.setString(6, c.getEmail());
	      
	      ps.executeUpdate();
	      ps.close();
	      con.close();
	}
	
	public String search(String email) throws SQLException {
	      String pass="";
	      Connection con=getConnection();
	      String sql="Select password from Customer where email=?";
	      PreparedStatement ps=con.prepareStatement(sql);
	      ps.setString(1, email);
	      ResultSet rs=ps.executeQuery();
	      
	      if(rs.next()) {
	         //int num2=rs.getInt(1);
	         pass=rs.getString("password");
	      }   
	      rs.close();
	      ps.close();
	      con.close();
	      return pass;
	}

	public Customer search(String userid, String password) throws SQLException {
	      Customer c=null;
	      Connection con=getConnection();
	      String sql="Select * from Customer where email=? and password=?";
	      PreparedStatement ps=con.prepareStatement(sql);
	      ps.setString(1, userid);
	      ps.setString(2, password);
	      ResultSet rs=ps.executeQuery();
	      if(rs.next()) {
	         String email = rs.getString("email");
	         String password2 = rs.getString("password");
	         String name = rs.getString("name");
	         String birth = rs.getString("birth");
	         String gender = rs.getString("gender");
	         int telNum = rs.getInt("telNum");
	         
	         c = new Customer
	               (email, password2, name, birth, gender, telNum);
	      }   
	      rs.close();
	      ps.close();
	      con.close();
	      return c;
	   }
	
	public void delete(String email) throws SQLException {
	      Connection con=getConnection();//2
	      String sql="Delete from Customer where EMAIL=?";
	      PreparedStatement ps=con.prepareStatement(sql);//3
	      ps.setString(1, email);
	      
	      ps.executeUpdate();
	      ps.close();
	      con.close();
	}
	
	
	
}
