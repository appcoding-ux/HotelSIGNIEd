package com.signied.controller.action;


public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		
		if(command.equals("people_num"))
			action = new PeopleNumAction();
		else if(command.equals("date_input"))
			action = new DateInputAction();
		else if(command.equals("search_room"))
			action = new SearchRoomList();
		else if(command.equals("get_date"))
			action = new GetSystemDateAction();
		

		return action;
	}
}
