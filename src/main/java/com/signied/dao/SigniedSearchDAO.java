package com.signied.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.signied.dto.RoomVO;
import com.signied.util.DBManager;

public class SigniedSearchDAO{

	private SigniedSearchDAO() {}
	private static SigniedSearchDAO instance = new SigniedSearchDAO();
	
	public static SigniedSearchDAO getInstance() {
		return instance;
	}
	public List<RoomVO> searchRoom(String date, int totalAmount) throws SQLException {
		
		List<RoomVO> list = new ArrayList<RoomVO>();
		String sql = "select * from room where inventory >= ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		RoomVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, totalAmount);
//			ps.setInt(2, date);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new RoomVO();
				vo.setRoomNum(rs.getInt("roomNum"));
				vo.setRoomName(rs.getString("roomname"));
				vo.setRoomType(rs.getString("ROOMTYPE"));
				vo.setViewType(rs.getString("viewType"));
				vo.setInventory(rs.getInt("inventory"));
				vo.setRoomCapacity(rs.getInt("roomCapacity"));
				vo.setImg(rs.getString("img"));
				
				list.add(vo);
				System.out.println("검색한 room list : " + vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
}
