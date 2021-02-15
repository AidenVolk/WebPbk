package com.bigbang.pbk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigbang.pbk.service.WebPbkService;
import com.bigbang.pbk.vo.WebPbkVO;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("msg", "아이디/비밀번호 필수");
		RequestDispatcher disp = request.getRequestDispatcher("joinForm.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebPbkVO person = new WebPbkVO();
		
		request.setCharacterEncoding("UTF-8");
		
		person.setName(request.getParameter("name"));
		person.setId(request.getParameter("id"));
		person.setPw(request.getParameter("pw"));
		person.setPhone1(request.getParameter("phone1"));
		person.setPhone2(request.getParameter("phone2"));
		person.setPhone3(request.getParameter("phone3"));
		person.setGender(request.getParameter("gender"));
		
		request.setAttribute("person", person);
		
		if(person.getId().equals("") || person.getName().contentEquals("")) {
			doGet(request,response);
		}else {
			WebPbkService wService = new WebPbkService();
			wService.insert(person);
			response.sendRedirect("loginForm.jsp");
		}
		
		
	}

}
