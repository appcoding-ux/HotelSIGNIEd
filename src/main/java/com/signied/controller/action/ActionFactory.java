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
		
		if(command.equals("search_room"))
			action = new SearchRoomAction();
		

		return action;
	}
}
