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

@WebServlet("/ShowByName")
public class ShowByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowByName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String name = request.getParameter("showByName");
		
		System.out.println(name);
		
		if(id == null) {
			response.sendRedirect("loginForm.jsp");
		}else {
			WebPbkService wService = new WebPbkService();
			WebPbkVO person = wService.showByName(name);
			
			request.setAttribute("person", person);
			
			RequestDispatcher disp = request.getRequestDispatcher("showByName.jsp");
			disp.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
