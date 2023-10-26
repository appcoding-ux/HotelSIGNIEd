package com.signied.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchRoomList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {

//		SigniedSearchDAO sDao = SigniedSearchDAO.getInstance();
//		List<RoomVO> roomList = sDao.selectAllBoards();
//		
//		request.setAttribute("roomList", roomList);
		
		RequestDispatcher dis = request.getRequestDispatcher("roomList.jsp");
		dis.forward(request, response);
	}

}
