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

@WebServlet("/UpdateLoginServlet")
public class UpdateLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		
		if(id.equals("")) {
			response.sendRedirect("Mainservlet");
		}else {
			WebPbkService wService = new WebPbkService();
			WebPbkVO person = wService.selectById(id);
					
			request.setAttribute("person", person);
			
			RequestDispatcher disp = request.getRequestDispatcher("updateLoginForm.jsp");
			disp.forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name		 = request.getParameter("name");
		String pw		 = request.getParameter("pw");
		String phone1	 = request.getParameter("phone1");
		String phone2 	 = request.getParameter("phone2");
		String phone3	 = request.getParameter("phone3");
		String gender	 = request.getParameter("gender");
		
		if(name.equals("") || phone1.equals("") || phone2.equals("") ||
		   pw.equals("")   || phone3.equals("") || gender.equals("")) {
			doGet(request,response);
		}else {
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			
			WebPbkService wService = new WebPbkService();
			WebPbkVO check = wService.login(id,pw);
			
			if(check != null) {
				WebPbkVO person = new WebPbkVO();
				
				person.setName(name);
				person.setId(id);
				person.setPw(pw);
				person.setPhone1(phone1);
				person.setPhone2(phone2);
				person.setPhone3(phone3);
				person.setGender(gender);
				
				wService.updateLogin(person);
				request.setAttribute("name", name);
				response.sendRedirect("MainServlet");
			}else {
				doGet(request,response);
			}
		}
	}
}
