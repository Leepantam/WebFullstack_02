package com.leepantam.s1.member;

import javax.servlet.http.HttpServletRequest;

import com.leepantam.s1.util.ActionFoward;

public class MemberService {
	private MemberDAO mDao;

	public void setmDao(MemberDAO mDao) {
		this.mDao = mDao;
	}

	// memberLogin
	public ActionFoward memberLogin(HttpServletRequest request) throws Exception {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		actionFoward.setPath("../WEB-INF/member/memberLogin.jsp");
		actionFoward.setCheck(true);
		MemberDTO mDto = (MemberDTO)request.getAttribute("dto");
		if(method.toUpperCase().equals("POST")) {
			
			mDto = mDao.login(mDto);
			
			System.out.println(mDto!=null);
			
			if(mDto != null) {
				actionFoward.setPath("../index.do");
				actionFoward.setCheck(false);				
			} else {
				actionFoward.setPath("../WEB-INF/member/memberLogin.jsp");
				actionFoward.setCheck(true);
			}
			
			
		}
		
		return actionFoward;
		
	}

	public ActionFoward memberJoin(HttpServletRequest request) throws Exception {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		actionFoward.setPath("../WEB-INF/member/memberJoin.jsp");
		actionFoward.setCheck(true);
		
		if(method.toUpperCase().equals("POST")) {	
			MemberDTO mDto = new MemberDTO();
			mDto.setID(request.getParameter("id"));
			mDto.setPW(request.getParameter("pw"));
			mDto.setNAME(request.getParameter("name"));
			mDto.setPHONE(request.getParameter("phone"));
			mDto.setEMAIL(request.getParameter("email"));
			int result = mDao.memberJoin(mDto);
			
			actionFoward.setPath("../index.do");
			actionFoward.setCheck(false);
		}
		
		return actionFoward;
		
	}
	
}
