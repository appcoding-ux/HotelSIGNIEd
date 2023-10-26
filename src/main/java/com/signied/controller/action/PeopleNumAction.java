package com.signied.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.json.tree.OracleJsonObjectImpl;
import oracle.sql.json.OracleJsonObject;

public class PeopleNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {


		
		System.out.println("어른 인원수" + request.getParameter("amountdata")); 
		System.out.println("어린이 인원수" + request.getParameter("childAmount")); 
		

	    
	    OracleJsonObject amountResult = new OracleJsonObjectImpl();
	    amountResult.put("amountView", request.getParameter("amountdata"));
	    amountResult.put("amountView2", request.getParameter("childAmount"));
	    
	    
	    response.setContentType("application/json");
	    
	    response.setCharacterEncoding("utf-8");
	    

	    response.getWriter().write(amountResult.toString());
		
	}

}
