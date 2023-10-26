package com.signied.controller.action;

import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.signied.dto.RoomVO;

public class SearchRoomAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {

		RoomVO vo = new RoomVO();
		System.out.println("달력 : " + request.getParameter("inputId"));
		String date = request.getParameter("inputId");
		String dateIn = date.substring(0,10);
		String dateIn2 = date.substring(12);
		String dateView = null;
		String dateView2= null;
		
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat outputFormat = new SimpleDateFormat("MM월 dd일 E요일");
		
		try {
		    dateView = outputFormat.format(inputFormat.parse(dateIn));  // 예: 11월 16일
		    dateView2 = outputFormat.format(inputFormat.parse(dateIn2));  // 예: 11월 16일
		} catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println(dateView);
		System.out.println(dateView2);
	}

}
