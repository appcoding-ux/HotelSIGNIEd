package com.signied.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.signied.dao.ReservationVO;
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
}
