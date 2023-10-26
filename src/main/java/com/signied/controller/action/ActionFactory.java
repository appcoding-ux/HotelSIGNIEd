package com.signied.controller.action;

public class ActionFactory {
	private ActionFactory() {
	}
	
	public static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println(command);
		
		if(command.equals("hotelQnA")) {
			action = new HotelQnAAction();
		}else if(command.equals("QnAwrite")) {
			action = new HotelQnAWriteAction();
		}else if(command.equals("QnAList")) {
			action = new HotelQnAListAction();
		}else if(command.equals("QnA_check")) {
			action = new HotelQnACheckFormAction();
		}else if(command.equals("QnA_check_pass")) {
			action = new HotelQnACheckAction();
		}else if(command.equals("QnA_view")) {
			action = new HotelQnAViewAction();
		}else if(command.equals("QnA_delete")) {
			action = new HotelQnADeleteAction();
		}else if(command.equals("QnA_admin_check_form")) {
			action = new HotelQnAadminCheckForm();
		}else if(command.equals("QnA_admin_check_pass")) {
			action = new HotelQnAadminCheckAction();
		}else if(command.equals("QnA_reply_form_admin")) {
			action = new HotelQnAReplyFormAction();
		}
		return action;
	}
}