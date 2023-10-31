package com.signied.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				vo.setRoomNum(rs.getInt(10));
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
				vo.setRoomNum(rs.getInt("roomNum2"));
				
				list.add(vo);
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public int insertReservation(ReservationVO vo1) {
		int result = -1;
		
		ReservationVO vo = null;
		String sql = "insert into reservation(reserveNum,reserveEmail, reserveName, reservePhone, checkIn, checkOut,guestNum, breakfast,roomNum) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getReserveNum());
			pstmt.setString(2, vo.getReserveEmail());
			pstmt.setString(3, vo.getReservePwd());
			pstmt.setString(4, vo.getReserveName());
			pstmt.setString(5, vo.getReservePhone());
			pstmt.setString(6, vo.getCheckIn());
			pstmt.setString(7, vo.getCheckOut());
			pstmt.setInt(8, vo.getGuestNum());
			pstmt.setInt(9, vo.getBreakfast());
			pstmt.setInt(10, vo.getRoomNum());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	public boolean isRoomAvailable(int roomNum, String checkIn, String checkOut) throws SQLException {
	    String sql = "SELECT r.roomNum, r.inventory, COALESCE(res.daily_reserved_count, 0) as daily_reserved_count "
	            + "FROM room r "
	            + "LEFT JOIN ( "
	            + "    SELECT roomNum, COUNT(*) as daily_reserved_count "
	            + "    FROM reservation "
	            + "    WHERE (checkIn <= TO_DATE( ? , 'YYYY-MM-DD') AND checkOut > TO_DATE( ? , 'YYYY-MM-DD')) "
	            + "    AND roomNum = ? "
	            + "    GROUP BY roomNum "
	            + ") res ON r.roomNum = res.roomNum "
	            + "WHERE r.roomNum = ?";

	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        conn = DBManager.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, checkIn);
	        ps.setString(2, checkOut);
	        ps.setInt(3, roomNum);
	        ps.setInt(4, roomNum);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            int inventory = rs.getInt("inventory");
	            int reservedCount = rs.getInt("daily_reserved_count");

	            return reservedCount < inventory;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, ps, rs);
	    }
	    return false;
	}

		
}