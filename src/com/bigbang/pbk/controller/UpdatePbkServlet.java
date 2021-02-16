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

@WebServlet("/UpdatePbkServlet")
public class UpdatePbkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePbkServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String num = request.getParameter("num");
		session.setAttribute("num",num);
		
		if(num.equals("")) {
			response.sendRedirect("Mainservlet");
		}else {
			WebPbkService wService = new WebPbkService();
			WebPbkVO person = wService.selectByNum(num);

			request.setAttribute("person", person);
			
			RequestDispatcher disp = request.getRequestDispatcher("updatePbkForm.jsp");
			disp.forward(request, response);
		}	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name		 = request.getParameter("name");
		String phone1	 = request.getParameter("phone1");
		String phone2 	 = request.getParameter("phone2");
		String phone3	 = request.getParameter("phone3");
		String gpnm	 	 = request.getParameter("gpnm");
		
		if(name.equals("") || phone1.equals("") || 
		   phone2.equals("") || phone3.equals("") ||
		   gpnm.equals("")) {
			doGet(request,response);
		}else {
			HttpSession session = request.getSession();
			String num = (String)session.getAttribute("num");
			WebPbkService wService = new WebPbkService();
			WebPbkVO check = wService.selectByNum(num);
			
			if(check != null) {
				WebPbkVO person = new WebPbkVO();
				
				person.setName(name);
				person.setNum(num);
				person.setPhone1(phone1);
				person.setPhone2(phone2);
				person.setPhone3(phone3);
				person.setGpnm(gpnm);

				wService.updatePbk(person);
				
				response.sendRedirect("MainServlet");
			}else {
				doGet(request,response);
			}
		}
	}
}
