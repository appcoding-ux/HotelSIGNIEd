package com.signied.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.signied.dto.ReservationVO;
import com.signied.util.DBManager;

public class ReservationDAO {
	private static ReservationDAO instance = new ReservationDAO();
	
	private ReservationDAO() {}
	
	public static ReservationDAO getInstance() {
		return instance;
	}
	
	public ReservationVO selectOneByNum(int num) {
		ReservationVO vo = null;
		String sql = "select * from reservation where RESERVENUM =?";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ReservationVO();
				vo.setReserveNum(rs.getInt(1));
				vo.setReserveEmail(rs.getString(2));
				vo.setReservePwd(rs.getString(3));
				vo.setReserveName(rs.getString(4));
				vo.setReservePhone(rs.getString(5));
				vo.setCheckIn(rs.getString(6));
				vo.setCheckOut(rs.getString(7));
				vo.setGuestNum(rs.getInt(8));
				vo.setBreakfast(rs.getInt(9));
				vo.setRoomNum2(rs.getInt(10));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	public List<ReservationVO> selectAllBoards() {
		
		List<ReservationVO> list = new ArrayList<ReservationVO>();
		ReservationVO vo = null;
		String sql = "select * from reservation where reserveNum = ?";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ReservationVO();
				vo.setReserveNum(rs.getInt("reserveNum"));
				vo.setReserveEmail(rs.getString("reserveEmail"));
				vo.setReservePwd(rs.getString("reservePwd"));
				vo.setReserveName(rs.getString("reserveName"));
				vo.setReservePhone(rs.getString("reservePhone"));
				vo.setCheckIn(rs.getString("checkIn"));
				vo.setCheckOut(rs.getString("checkOut"));
				vo.setGuestNum(rs.getInt("guestNum"));
				vo.setBreakfast(rs.getInt("breakfast"));
				vo.setRoomNum2(rs.getInt("roomNum2"));
				
				list.add(vo);
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}