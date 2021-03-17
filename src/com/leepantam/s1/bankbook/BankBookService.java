package com.leepantam.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.leepantam.s1.util.ActionFoward;

public class BankBookService {

	private BankBookDAO bDao;


	public void setbDao(BankBookDAO bDao) {
		this.bDao = bDao;
	}


	//BankBookDAO의 getList 호출 후 
	public ActionFoward getList(HttpServletRequest request) throws Exception{
		ActionFoward actionFoward = new ActionFoward();
		List<BankBookDTO> list = bDao.getList();

		request.setAttribute("list", list);
		actionFoward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
		actionFoward.setCheck(true);

		return actionFoward;

	}

	public ActionFoward getSelect(HttpServletRequest request) throws Exception{
		ActionFoward actionFoward = new ActionFoward();
		BankBookDTO bDto = new BankBookDTO();
		bDto.setACCOUNT_NUMBER(Integer.parseInt(request.getParameter("account_number")));

		bDto=bDao.getSelect(bDto);

		request.setAttribute("search", bDto);
		actionFoward.setPath("../WEB-INF/bankbook/bankbookSelect.jsp");
		actionFoward.setCheck(true);

		return actionFoward;
	}


	public ActionFoward setWrite(HttpServletRequest request) throws Exception {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		actionFoward.setPath("../WEB-INF/bankbook/bankbookWrite.jsp");
		actionFoward.setCheck(true);
		
		if(method.toUpperCase().equals("POST")) {
			BankBookDTO bDto = new BankBookDTO();
			bDto.setACCOUNT_NAME(request.getParameter("account_name"));
			bDto.setINTEREST_RATE(Double.parseDouble(request.getParameter("interest_rate")));
			bDto.setCAN_MAKE(request.getParameter("can_make"));
			bDao.setWrite(bDto);
			actionFoward.setPath("./bankbookList.do");
			
			/***************************
			 * // 윗줄에서 bankbookList.jsp로 바로 가면 bankbookList.jsp에서 리스트를 못만들어줌 왜냐 List가 없으니까
			*/
			
			actionFoward.setCheck(false);
		} 


		return actionFoward;

	}
}
