package com.signied.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.signied.dao.ReservationDAO;
import com.signied.dto.ReservationVO;

public class ReservationSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		ReservationDAO rDao = ReservationDAO.getInstance();
		
		int roomNum = Integer.parseInt(request.getParameter("roomNum"));
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");
		
		request.setAttribute("checkIn", checkIn);
		request.setAttribute("checkOut", checkOut);
		request.setAttribute("originCheckIn", request.getParameter("originCheckIn"));
		request.setAttribute("originCheckout", request.getParameter("originCheckout"));
		request.setAttribute("adult", request.getParameter("adultAmount"));
		request.setAttribute("child", request.getParameter("childAmount"));
		request.setAttribute("bak", request.getParameter("bak"));
		request.setAttribute("roomNum", roomNum);

		boolean roomAvailable =  rDao.isRoomAvailable(roomNum, checkIn, checkOut);
		if(roomAvailable == true) {
	
			String url = "roomReservation.jsp";
	
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			System.out.println("예약자 이름 : " + name);
			System.out.println("예약자 전번 : " + phone);
			System.out.println("예약자 이멜 : " + email);
	
			ReservationVO vo = new ReservationVO();
	
			vo.setReserveName(request.getParameter("name"));
			vo.setReservePhone(request.getParameter("phone"));
			vo.setReserveEmail(request.getParameter("email"));
	
			int result = rDao.insertReservation(vo);
	
			if (result == 1) {
				url = "index.jsp";
			}
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}else { 
			RequestDispatcher dis = request.getRequestDispatcher("roomList.jsp");
			dis.forward(request, response);}
		
		
	}
	

}
