package com.leepantam.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankBookDAO {
	//getList
	
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> array =new ArrayList<>();
		
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		
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
		
		rs.close();
		st.close();
		con.close();
		return array;
	}
	
	
	
	public BankBookDTO getSelect(BankBookDTO bDto) throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "select * from bank_book where account_number=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, bDto.getACCOUNT_NUMBER());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bDto.setACCOUNT_NUMBER(rs.getInt("account_number"));
			bDto.setACCOUNT_NAME(rs.getString("account_name"));
			bDto.setINTEREST_RATE(rs.getDouble("interest_rate"));
			bDto.setCAN_MAKE(rs.getString("can_make"));
		} else {
			bDto=null;
		}
		
		rs.close();
		st.close();
		con.close();
		
		return bDto;
		
	}
	
	public int setWrite(BankBookDTO bDto) throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "insert into bank_book values(bank_seq.nextval,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bDto.getACCOUNT_NAME());
		st.setDouble(2, bDto.getINTEREST_RATE());
		st.setString(3, bDto.getCAN_MAKE());
		
		int result=st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
}
