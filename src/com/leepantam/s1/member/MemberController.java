package com.leepantam.s1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leepantam.s1.util.ActionFoward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService mServ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	mServ = new MemberService();
    	MemberDAO mDao = new MemberDAO();
    	mServ.setmDao(mDao);
    	super.init();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Member Controller!!");
		
		String uri = request.getRequestURI();
		String path = request.getServletPath();
		System.out.println(path);
		System.out.println(uri);
		
		// substring
		String result= uri.substring(uri.lastIndexOf('/')+1);
		System.out.println(result);
		String pathInfo = "";
		ActionFoward actionFoward = null;
		
		if(result.equals("memberLogin.do")) {
			MemberDTO mDto = new MemberDTO();
			mDto.setID(request.getParameter("id"));
			mDto.setPW(request.getParameter("pw"));
			request.setAttribute("dto", mDto);
			
			try {
				actionFoward = mServ.memberLogin(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(result.equals("memberJoin.do")){
			
			try {
				actionFoward = mServ.memberJoin(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("error");
		}
		
		//forward
		if(actionFoward.isCheck()) {
		RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
		view.forward(request, response);
		} else {
			//redirect
			response.sendRedirect(actionFoward.getPath());
			
		
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
