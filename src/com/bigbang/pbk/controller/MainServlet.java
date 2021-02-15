package com.bigbang.pbk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.pbk.service.WebPbkService;
import com.bigbang.pbk.vo.WebPbkVO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name 		= (String)session.getAttribute("name");
		String id 			= (String)session.getAttribute("id");
		
		if(name == null || id == null) {
			response.sendRedirect("LoginServlet");
		}else {
			WebPbkService wService = new WebPbkService();
			ArrayList<WebPbkVO> login = wService.selectAll(id);
			
			request.setAttribute("login", login);
			
			RequestDispatcher disp = request.getRequestDispatcher("main.jsp");
			disp.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
