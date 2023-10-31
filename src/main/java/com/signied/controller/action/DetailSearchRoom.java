package com.signied.controller.action;

import java.util.Arrays;
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
		
		// 첫 번째 검색 로직
	    String checkIn = request.getParameter("originCheckIn");
	    String checkOut = request.getParameter("originCheckOut");
	    int totalAmount = Integer.parseInt(request.getParameter("adultCount"))
	            + Integer.parseInt(request.getParameter("childCount"));
	    List<RoomVO> roomList = sDao.searchRoom(checkIn, checkOut, totalAmount);

	    // 상세 검색 로직 (roomList를 기반으로 상세 검색)
	    String sort = request.getParameter("fee");
	    String[] viewTypes = request.getParameterValues("view");
	    List<String> viewTypeList = Arrays.asList(viewTypes != null ? viewTypes : new String[]{});
	    
	    String[] roomTypes = request.getParameterValues("room");
	    List<String> roomTypesList = Arrays.asList(roomTypes != null ? roomTypes : new String[]{});
	    
	    roomList = sDao.detailSearchRoom(sort, viewTypeList, roomTypesList, roomList);  // roomList를 인자로 추가

		
//		 // viewTypes null 값이 나오는 경우가 있어서 수정한 코드
//	      if(viewTypes != null) {
//	         for(int i = 0; i < viewTypes.length; i++) {
//	            viewTypeList.add(viewTypes[i]);
//	         }
//	      }
//	      
//	     
//	      if(roomTypes != null) {
//	         for(int i = 0; i < roomTypes.length; i++) {
//	            roomTypesList.add(roomTypes[i]);
//	         }
//	      }
	    
	     
		
		if(roomList.isEmpty()) {
			request.setAttribute("message", "해당 일자에 예약 가능한 객실 및 상품조회 결과가 없습니다.\n"
					+ "\n"
					+ "상단 예약 검색바에서 일정을 변경하신 후 수정 버튼을 다시 한 번 클릭해 주세요.");
		}else {
			request.setAttribute("roomList", roomList);
		}
			
		
		
		
		 

		
		//String checkIn = request.getParameter("originCheckIn");
		//String checkOut = request.getParameter("originCheckOut");
		request.setAttribute("originCheckIn", checkIn);
		request.setAttribute("originCheckOut", checkOut);
		request.setAttribute("bak", request.getParameter("bak"));
		request.setAttribute("adult", request.getParameter("adultCount"));
		request.setAttribute("child", request.getParameter("childCount"));
		request.setAttribute("checkIn", request.getParameter("checkIn"));
		request.setAttribute("checkOut", request.getParameter("checkOut"));
		System.out.println("detail adultCount : " + request.getParameter("adultCount"));
		System.out.println("detail childCount : " + request.getParameter("childCount"));
		System.out.println("detail checkIn :" + request.getParameter("checkIn"));
		System.out.println("detail checkOut : " + request.getParameter("checkOut"));
		RequestDispatcher dis = request.getRequestDispatcher("roomList.jsp");
		dis.forward(request, response);
	}

}
