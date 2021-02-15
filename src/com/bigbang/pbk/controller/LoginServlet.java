package com.bigbang.pbk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.pbk.service.WebPbkService;
import com.bigbang.pbk.vo.WebPbkVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			response.sendRedirect("loginForm.jsp");
		}else {
			doPost(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		WebPbkService wService 	= new WebPbkService();
		WebPbkVO person 	   	= wService.login(id, pw);
		
		if(person.getId() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("name", person.getName());
			session.setAttribute("id", person.getId());
			response.sendRedirect("MainServlet");
		}else {
			response.sendRedirect("loginForm.jsp");
		}
		
	}

}
