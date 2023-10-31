package com.signied.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailSearchRoom implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
	   System.out.println(request.getParameter("view_city"));
	   System.out.println(request.getParameter("view_ocean"));
	   System.out.println(request.getParameter("view_haver"));
	   System.out.println(request.getParameter("room_double"));
	   System.out.println(request.getParameter("room_twin"));
	   System.out.println(request.getParameter("room_family"));
	   
//      SigniedSearchDAO sDao = SigniedSearchDAO.getInstance();
//      String sort = null;
//      List<String> viewTypes = null;
//      List<String> roomTypes =null;
//      sDao.detailSearchRoom(sort, viewTypes, roomTypes);
   }

}
