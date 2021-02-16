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

@WebServlet("/DeletePbkServlet")
public class DeletePbkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePbkServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String num = (String)session.getAttribute("num");
		
		if(num.equals("")) {
			response.sendRedirect("Mainservlet");
		}else {
			WebPbkService wService = new WebPbkService();
			wService.deletePbk(num);
			
			RequestDispatcher disp = request.getRequestDispatcher("MainServlet");
			disp.forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
