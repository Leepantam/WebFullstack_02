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
	public List<BankBookDTO> getList() {
		ActionFoward actionFoward = new ActionFoward();
		actionFoward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
		List<BankBookDTO> list = null;
		try {
			list = bDao.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
}
