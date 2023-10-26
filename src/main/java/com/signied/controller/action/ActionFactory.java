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
		if(command.equals("reservation_inquiry")) {
			action = new ReservationIuquiryAction();
		}else if(command.equals("Reservation_Num")) {
			action = new ReservationCheckAction();
		}
		

		return action;
	}
}
