package com.signied.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservationSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		System.out.println("리스트에서 넘긴 데이터" + request.getParameter("checkIn"));
		System.out.println("리스트에서 넘긴 데이터" + request.getParameter("checkOut"));
		System.out.println("리스트에서 넘긴 데이터" + request.getParameter("adultAmount"));
		System.out.println("리스트에서 넘긴 데이터" + request.getParameter("childAmount"));
		System.out.println("리스트에서 넘긴 데이터" + request.getParameter("bak"));
		System.out.println("리스트에서 넘긴 데이터" + request.getParameter("roomNum"));
		
		request.setAttribute("checkIn", request.getParameter("checkIn"));
		request.setAttribute("checkOut", request.getParameter("checkOut"));
		request.setAttribute("adult", request.getParameter("adultAmount"));
		request.setAttribute("child", request.getParameter("childAmount"));
		request.setAttribute("bak",request.getParameter("bak"));
		request.setAttribute("roomNum",request.getParameter("roomNum"));
		
		RequestDispatcher dis = request.getRequestDispatcher("roomReservation.jsp");
		dis.forward(request, response);
	}
	

}
