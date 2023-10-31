package com.signied.controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.signied.dao.SigniedSearchDAO;
import com.signied.dto.RoomVO;

public class DetailSearchRoom implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		SigniedSearchDAO sDao = SigniedSearchDAO.getInstance();
		String sort = request.getParameter("fee");
		
		String[] viewTypes = request.getParameterValues("view");
		List<String> viewTypeList = new ArrayList<>();
		String[] roomTypes = request.getParameterValues("room");
		List<String> roomTypesList = new ArrayList<>();
		System.out.println(sort);
		
		for(int i = 0; i < viewTypes.length; i++) {
			viewTypeList.add(viewTypes[i]);
		}
		for(int i = 0; i < roomTypes.length; i++) {
			roomTypesList.add(roomTypes[i]);
		}

		List<RoomVO> roomList = sDao.detailSearchRoom(sort, viewTypeList, roomTypesList);
		
		request.setAttribute("roomList", roomList);
		
		RequestDispatcher dis = request.getRequestDispatcher("roomList.jsp");
		dis.forward(request, response);
	}

}
