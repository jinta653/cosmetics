package edu.smu.cosmetics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.smu.cosmetics.vo.Cosmetics;
import edu.smu.cosmetics.vo.CosmeticsBrandVo;

public class Cosmetics_BrandDao {
	
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
	
	public ArrayList<CosmeticsBrandVo> list() throws SQLException{
		ArrayList<CosmeticsBrandVo> result = new ArrayList<CosmeticsBrandVo>();
		Connection con = getConnection();
		String sql = "select * from cosmetics_brand ORDER by COBRN_NAME";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int cobrn_num=rs.getInt("cobrn_num");
			String cobrn_name=rs.getString("cobrn_name");
						
			CosmeticsBrandVo b = new CosmeticsBrandVo(cobrn_num,cobrn_name);
			result.add(b);
		}
		ps.close();
	    con.close();
	    return result;
	}

}
