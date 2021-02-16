package com.bigbang.pbk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.pbk.service.WebPbkService;
import com.bigbang.pbk.vo.WebPbkVO;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("msgName", "* 이름 입력 필수");
		request.setAttribute("msgNumber", "* 전화번호 입력 필수");
		request.setAttribute("msgGroup", "* 그룹 선택 필수");
		RequestDispatcher disp = request.getRequestDispatcher("insertForm.jsp");
		disp.forward(request,response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id 			= (String)session.getAttribute("id");
		WebPbkVO person 	= new WebPbkVO();
			
		request.setCharacterEncoding("UTF-8");
		person.setId(id);
		person.setName(request.getParameter("name"));
		person.setPhone1(request.getParameter("phone1"));
		person.setPhone2(request.getParameter("phone2"));
		person.setPhone3(request.getParameter("phone3"));
		person.setGpnm(request.getParameter("gpnm"));
			
		request.setAttribute("person", person);
			
		if(person.getName().equals("") || person.getPhone1().equals("") ||
		   person.getPhone2().equals("") || person.getPhone3().equals("") ||
		   person.getGpnm().equals("") || person.getId().equals("")) {
			doGet(request,response);
		}else {
			WebPbkService wService = new WebPbkService();
			wService.insertPbk(person);
			response.sendRedirect("MainServlet");
		}
	}
}
