package com.signied.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.signied.dao.ReservationDAO;
import com.signied.dto.ReservationVO;

public class ReservationSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = null;
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		System.out.println("예약자 이름 : " +name);
		System.out.println("예약자 전번 : " +phone);
		System.out.println("예약자 이멜 : " +email);
		
		ReservationVO vo = new ReservationVO();
		
		vo.setReserveName(request.getParameter("name"));
		vo.setReservePhone(request.getParameter("phone"));
		vo.setReserveEmail(request.getParameter("email"));
		
		ReservationDAO rDao = ReservationDAO.getInstance();
		int result = rDao.insertReservation(vo);
		
		
		if(result==1) {
			url = "index.jsp";
		}
	}

}
