package com.leepantam.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankBookDAO {
	//getList
	
	public ArrayList<BankBookDTO> getList() throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		
		ArrayList<BankBookDTO> array =new ArrayList<>();
		BankBookDTO bDto;
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "select * from bank_book";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			bDto = new BankBookDTO();
			bDto.setACCOUNT_NUMBER(rs.getInt("account_number"));
			bDto.setACCOUNT_NAME(rs.getString("account_name"));
			bDto.setINTEREST_RATE(rs.getDouble("interest_rate"));
			bDto.setCAN_MAKE(rs.getString("can_make"));
			array.add(bDto);
		}
		return array;
	}
}
