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
	public List<RoomVO> selectAllBoards() throws SQLException {
		
		List<RoomVO> list = new ArrayList<RoomVO>();
		String sql = "";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		RoomVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new RoomVO();
				
				
				
				
				
				
				
				
				
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
}
