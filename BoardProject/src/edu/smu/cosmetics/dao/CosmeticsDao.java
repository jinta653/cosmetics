package edu.smu.cosmetics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.smu.board.vo.Board;
import edu.smu.cosmetics.vo.Cosmetics;


public class CosmeticsDao {
	
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
	
	
	public ArrayList<Cosmetics> search() throws SQLException{
		ArrayList<Cosmetics> result = new ArrayList<Cosmetics>();
		Connection con = getConnection();
		String sql = "select * from cosmetics ORDER by cos_num desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int cos_num=rs.getInt("cos_num");
			String img_name=rs.getString("img_name");
			String name=rs.getString("name");
			String explain=rs.getString("explain");
			String capacity=rs.getString("capacity");
			int price=rs.getInt("price");
			
			Cosmetics b = new Cosmetics(cos_num,img_name,name,explain,capacity,price);
			result.add(b);
		}
		ps.close();
	    con.close();
	    return result;
	}
	
	public ArrayList<Cosmetics> brand_search() throws SQLException{
		ArrayList<Cosmetics> result = new ArrayList<Cosmetics>();
		Connection con = getConnection();
		String sql = "select COBRN_NUM, COBRN_NAME, COKIN_NUM, COKIN_NAME from COSMETICS_V where COBRN_NUM=2 and cokin_num=1 order by COBRN_NUM";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int cos_num=rs.getInt("cos_num");
			String img_name=rs.getString("img_name");
			String name=rs.getString("name");
			String explain=rs.getString("explain");
			String capacity=rs.getString("capacity");
			int price=rs.getInt("price");
			
			Cosmetics b = new Cosmetics(cos_num,img_name,name,explain,capacity,price);
			result.add(b);
		}
		ps.close();
	    con.close();
	    return result;
	}
	
	public ArrayList<Cosmetics> brand_kind_search() throws SQLException{
		ArrayList<Cosmetics> result = new ArrayList<Cosmetics>();
		Connection con = getConnection();
		String sql = "select 'COSMETICS_BRANKIN'.'COBRN_NUM' as 'COBRN_NUM',"
				+ " 'COSMETICS_BRAND'.'COBRN_NAME' as 'COBRN_NAME',"
				+ " 'COSMETICS_BRANKIN'.'COKIN_NUM' as 'COKIN_NUM',"
				+ " 'COSMETICS_KIND'.'COKIN_NAME' as 'COKIN_NAME'"
				+ " from 'COSMETICS_BRANKIN' 'COSMETICS_BRANKIN',"
				+ " 'COSMETICS_KIND' 'COSMETICS_KIND',"
				+ " 'COSMETICS_BRAND' 'COSMETICS_BRAND'"
				+ " where 'COSMETICS_BRAND'.'COBRN_NUM'='COSMETICS_BRANKIN'.'COBRN_NUM"
				+ " and	'COSMETICS_KIND'.'COKIN_NUM'='COSMETICS_BRANKIN'.'COKIN_NUM'"
				+ " and 'COSMETICS_BRAND'.'COBRN_NUM'=? "
				+ " and 'COSMETICS_KIND'.'COKIN_NUM'=?"
				+ " order by 'COSMETICS_BRAND'.'COBRN_NUM";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int cos_num=rs.getInt("cos_num");
			String img_name=rs.getString("img_name");
			String name=rs.getString("name");
			String explain=rs.getString("explain");
			String capacity=rs.getString("capacity");
			int price=rs.getInt("price");
			
			Cosmetics b = new Cosmetics(cos_num,img_name,name,explain,capacity,price);
			result.add(b);
		}
		ps.close();
	    con.close();
	    return result;
	}
	
	
	
	
	public Cosmetics search(int num) throws SQLException {
		Cosmetics n=null;
		Connection con=getConnection();//2
		String sql="Select * from cosmetics where cos_num=?";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setInt(1, num);
		ResultSet rs=ps.executeQuery();//4
		if(rs.next()) {
			//int num2=rs.getInt(1);
			String name=rs.getString("name");
			String capacity=rs.getString("capacity");
			int price=rs.getInt("price");
			String explain=rs.getString("explain");
			String img_name=rs.getString("img_name");
			int brand_num=rs.getInt("cobrn_num");
			int kind_num=rs.getInt("cokin_num");
			int average=rs.getInt("average");
			String link=rs.getString("link");
			n=new Cosmetics(num, name, capacity,price,explain,img_name,brand_num,kind_num,average,link);
		}	
		ps.close();
		con.close();
		return n;
	}
	
	public ArrayList<Cosmetics> all_search() throws SQLException{
		ArrayList<Cosmetics> result = new ArrayList<Cosmetics>();
		Connection con = getConnection();
		String sql = "select * from Cosmetics ORDER by cos_num desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			//int num2=rs.getInt(1);
			int cos_num=rs.getInt("cos_num");
			String name=rs.getString("name");
			String capacity=rs.getString("capacity");
			int price=rs.getInt("price");
			String explain=rs.getString("explain");
			String img_name=rs.getString("img_name");
			int brand_num=rs.getInt("cobrn_num");
			int kind_num=rs.getInt("cokin_num");
			int average=rs.getInt("average");
			String link=rs.getString("link");
			Cosmetics n=new Cosmetics(cos_num, name, capacity,price,explain,img_name,brand_num,kind_num,average,link);
			result.add(n);
		}	
		ps.close();
	    con.close();
	    return result;
	}
	
	
	
	public ArrayList<Cosmetics> search(int cobrn_num,int cokin_num) throws SQLException {
		ArrayList<Cosmetics> result = new ArrayList<Cosmetics>();
		Cosmetics n=null;
		Connection con=getConnection();//2
		String sql="Select * from cosmetics where cobrn_num=? and cokin_num=? ";
		PreparedStatement ps=con.prepareStatement(sql);//3
		ps.setInt(1, cobrn_num);
		ps.setInt(2, cokin_num);
		ResultSet rs=ps.executeQuery();//4
		while(rs.next()) {
			//int num2=rs.getInt(1);
			int cos_num=rs.getInt("cos_num");
			String name=rs.getString("name");
			String capacity=rs.getString("capacity");
			int price=rs.getInt("price");
			String explain=rs.getString("explain");
			String img_name=rs.getString("img_name");
			int brand_num=rs.getInt("cobrn_num");
			int kind_num=rs.getInt("cokin_num");
			int average=rs.getInt("average");
			String link=rs.getString("link");
			n=new Cosmetics(cos_num, name, capacity,price,explain,img_name,brand_num,kind_num,average,link);
			result.add(n);
		}	
		ps.close();
		con.close();
		return result;
	}
	
	/*public void updateRate(int num) throws SQLException {
		Connection con = getConnection();
		String rateQ = "update board set rate = rate+1 where num = ?";
		PreparedStatement ps = con.prepareStatement(rateQ);
		ps.setInt(1, num);
		
		ps.executeUpdate();	
		
		ps.close();
		con.close();
		
	}*/
	
}
