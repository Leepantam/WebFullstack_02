package com.leepantam.s1.test;

import com.leepantam.s1.member.MemberDAO;
import com.leepantam.s1.member.MemberDTO;

public class MemberDAOTest {

	public static void main(String[] args) {
		// Web에서 메인 메서드는 테스트 용로도만 사용
		
		MemberDTO mDto = new MemberDTO();
		mDto.setID("user01");
		mDto.setPW("user01");
		MemberDAO mDao = new MemberDAO();
		
		try {
			mDto=mDao.login(mDto);
			
			System.out.println(mDto != null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
