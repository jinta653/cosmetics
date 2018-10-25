package edu.smu.cosmetics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.smu.cosmetics.vo.CosmeticsBrandKindVo;
import edu.smu.cosmetics.vo.CosmeticsBrandVo;

public class Cosmetics_Brand_KindDao {
	
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
	
	public ArrayList<CosmeticsBrandKindVo> list(int cobrn_num) throws SQLException{
		ArrayList<CosmeticsBrandKindVo> result = new ArrayList<CosmeticsBrandKindVo>();
		Connection con = getConnection();
		String sql = "select * from COSMETICS_V where COBRN_NUM = ? ORDER by COKIN_NAME";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cobrn_num);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int cokin_num=rs.getInt("cokin_num");
			String cokin_name=rs.getString("cokin_name");
						
			CosmeticsBrandKindVo b = new CosmeticsBrandKindVo(cokin_num,cokin_name);
			result.add(b);
		}
		ps.close();
	    con.close();
	    System.out.println("cobrn_num="+cobrn_num+"     "+getClass().getName()+"list().size()="+result.size());
	    return result;
	}
	

}
