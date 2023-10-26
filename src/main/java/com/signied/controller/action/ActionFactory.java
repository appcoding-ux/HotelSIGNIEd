package com.signied.controller.action;


public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
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
		}else if(command.equals("search_room")){}
			action = new SearchRoomAction();
		}
		return action;
	}
}
