package com.signied.controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.signied.dao.QnADAO;
import com.signied.dto.QnAVO;

public class HotelQnAListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		List<QnAVO> list = new ArrayList<>();
		
		QnADAO dao = QnADAO.getInstance();
		list = dao.getAllQnAList();
		
		request.setAttribute("QnAList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("QnAList.jsp");
		dis.forward(request, response);
	}

}
