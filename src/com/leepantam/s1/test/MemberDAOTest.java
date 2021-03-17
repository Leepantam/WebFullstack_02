package com.leepantam.s1.test;

import java.util.List;

import com.leepantam.s1.bankbook.BankBookDAO;
import com.leepantam.s1.bankbook.BankBookDTO;
import com.leepantam.s1.member.MemberDAO;
import com.leepantam.s1.member.MemberDTO;

public class MemberDAOTest {

	public static void main(String[] args) {
		// Web에서 메인 메서드는 테스트 용로도만 사용
		/*
		MemberDTO mDto = new MemberDTO();
		mDto.setID("user04");
		mDto.setPW("user04");
		mDto.setNAME("Tester4");
		mDto.setPHONE("010-1010-0104");
		mDto.setEMAIL("test4@tester.com");
		
		MemberDAO mDao = new MemberDAO();
		
		try {
//			mDto=mDao.login(mDto);
//			
//			System.out.println(mDto != null);
			int test = mDao.memberJoin(mDto);
			System.out.println(test != 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		BankBookDTO bDto;
		BankBookDAO bDao = new BankBookDAO();
		try {
			List<BankBookDTO> arr = bDao.getList();
			for(int i=0; i<arr.size();i++) {
				System.out.print(arr.get(i).getACCOUNT_NUMBER()+"/");
				System.out.print(arr.get(i).getACCOUNT_NAME()+"/");
				System.out.print(arr.get(i).getINTEREST_RATE()+"/");
				System.out.println(arr.get(i).getCAN_MAKE());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
