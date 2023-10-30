package com.signied.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.signied.dao.SigniedSearchDAO;
import com.signied.dto.RoomVO;

public class SearchRoomList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {

		SigniedSearchDAO sDao = SigniedSearchDAO.getInstance();
		
		//client가 원하는 날짜 -> header.jsp에서 넘어옴
		String date = request.getParameter("input-id");
		System.out.println(date);
		
		//client가 원하는 인원수 -> header.jsp에서 넘어옴
		int totalAmount = Integer.parseInt(request.getParameter("adultAmount")) 
							+Integer.parseInt(request.getParameter("childAmount"));
		
		List<RoomVO> roomList = sDao.searchRoom(date,totalAmount);
		request.setAttribute("roomList", roomList);
		
		String dateIn = request.getParameter("date_day");
		String dateIn2 = request.getParameter("date_day2");
		request.setAttribute("dateIn", dateIn);
		request.setAttribute("dateIn2", dateIn2);
		System.out.println("헤더에서 넘긴 데이터" + dateIn);
		System.out.println("헤더에서 넘긴 데이터" + dateIn2);
	  
		
		RequestDispatcher dis = request.getRequestDispatcher("roomList.jsp");
		dis.forward(request, response);
	}

}
