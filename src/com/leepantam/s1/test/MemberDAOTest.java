package com.leepantam.s1.test;

import java.util.List;

import com.leepantam.s1.bankbook.BankBookDAO;
import com.leepantam.s1.bankbook.BankBookDTO;
import com.leepantam.s1.member.MemberDAO;
import com.leepantam.s1.member.MemberDTO;

public class MemberDAOTest {

	public static void main(String[] args) {
		// Web에서 메인 메서드는 테스트 용로도만 사용
		
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
		
		
		

	}

}
