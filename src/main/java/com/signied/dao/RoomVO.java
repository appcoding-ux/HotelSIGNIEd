package com.signied.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomVO {
	
	   private int roomNum;
	   private String roomName;
	   private String roomType;
	   private String viewType;
	   private int roomCapacity;
	   private int roomPrice;
	   private int inventory;
	   private String img;
}
