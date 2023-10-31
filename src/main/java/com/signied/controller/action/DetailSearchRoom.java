package com.signied.controller.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.signied.dao.SigniedSearchDAO;
import com.signied.dto.RoomVO;

public class DetailSearchRoom implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
        SigniedSearchDAO sDao = SigniedSearchDAO.getInstance();

        String viewType = request.getParameter("viewType");
        String roomType = request.getParameter("roomType");
        String fee = request.getParameter("fee"); // fee 파라미터 추가

        System.out.println("요청한 뷰타입 : " + viewType);
        System.out.println("요청한 룸타입: " + roomType);
        System.out.println("정렬 기준: " + fee);

        
        // fee 파라미터 값에 따라 정렬 방법을 설정
        if ("asc".equals(fee)) {
            fee = "ASC";
        } else if ("desc".equals(fee)) {
        	fee = "DESC";
        }

        List<RoomVO> rooms = sDao.getRoomsByTypeAndView(viewType, roomType, fee);

        // 이후에 rooms를 request에 넣고 JSP로 전달하는 코드 추가
        request.setAttribute("rooms", rooms);

        // ... 이하 생략
    }
}
