package com.leepantam.s1.test;

import java.util.List;

import com.leepantam.s1.bankbook.BankBookDAO;
import com.leepantam.s1.bankbook.BankBookDTO;

public class BankBookTest {
	public static void main(String[] args) {
		
		BankBookDTO bDto = new BankBookDTO();
		BankBookDAO bDao = new BankBookDAO();
		try {
//			List<BankBookDTO> arr = bDao.getList();
//			for(int i=0; i<arr.size();i++) {
//				System.out.print(arr.get(i).getACCOUNT_NUMBER()+"/");
//				System.out.print(arr.get(i).getACCOUNT_NAME()+"/");
//				System.out.print(arr.get(i).getINTEREST_RATE()+"/");
//				System.out.println(arr.get(i).getCAN_MAKE());
//			}
			
//			bDto.setACCOUNT_NUMBER(1);
//			bDto=bDao.getSelect(bDto);
//			if(bDto!=null) {
//				System.out.println(bDto.getACCOUNT_NUMBER());
//				System.out.println(bDto.getACCOUNT_NAME());
//				System.out.println(bDto.getINTEREST_RATE());
//				System.out.println(bDto.getCAN_MAKE());
//			}
			
			bDto.setACCOUNT_NAME("확인");
			bDto.setINTEREST_RATE(1.1);
			bDto.setCAN_MAKE("Y");
			int result=bDao.setWrite(bDto);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
