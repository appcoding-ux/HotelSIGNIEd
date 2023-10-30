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
	   public List<RoomVO> searchRoom(String checkIn, String checkOut, int totalAmount) throws SQLException {
		      
		      List<RoomVO> list = new ArrayList<RoomVO>();
		      String sql = "SELECT r.roomNum, r.roomName, r.roomType, r.viewType, r.roomCapacity, r.roomPrice, r.inventory, r.img\n"
		            + "FROM room r\n"
		            + "LEFT JOIN (\n"
		            + "    SELECT roomNum, COUNT(*) as daily_reserved_count\n"
		            + "    FROM reservation\n"
		            + "    WHERE (checkIn <= TO_DATE( ? , 'YYYY-MM-DD') AND checkOut > TO_DATE( ? , 'YYYY-MM-DD')) \n"
		            + "    GROUP BY roomNum\n"
		            + ") res ON r.roomNum = res.roomNum\n"
		            + "WHERE r.roomCapacity >= ? \n"
		            + "AND COALESCE(res.daily_reserved_count, 0) < r.inventory "
		            + "ORDER BY r.roomPrice ASC";
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      RoomVO vo = null;
		      
		      try {
		         conn = DBManager.getConnection();
		         ps = conn.prepareStatement(sql);
		         ps.setString(1, checkIn);
		         ps.setString(2, checkOut);
		         ps.setInt(3, totalAmount);

		         rs = ps.executeQuery();
		         
		         while(rs.next()) {
		            vo = new RoomVO();
		            vo.setRoomNum(rs.getInt("roomNum"));
		            vo.setRoomName(rs.getString("roomname"));
		            vo.setRoomType(rs.getString("ROOMTYPE"));
		            vo.setViewType(rs.getString("viewType"));
		            vo.setInventory(rs.getInt("inventory"));
		            vo.setRoomCapacity(rs.getInt("roomCapacity"));
		            vo.setRoomPrice(rs.getInt("roomPrice")); 
		            vo.setImg(rs.getString("img"));
		            
		            list.add(vo);
//		            System.out.println("검색한 room list : " + vo);
		         }
		         
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         DBManager.close(conn, ps, rs);
		      }
		      return list;
		   }
	 
	 // 낮은 가격순으로 방 정보만 가져오는 메서드
    public List<RoomVO> getRoomsByTypeAndView(String viewType, String roomType, String sort) throws SQLException {
        List<RoomVO> list = new ArrayList<>();
        String sql = "SELECT * FROM room WHERE ROOMTYPE = ? AND VIEWTYPE = ? ORDER BY ROOMPRICE ASC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        RoomVO vo = null;

        try {
            conn = DBManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, roomType);
            ps.setString(2, viewType); 
            ps.setString(3, sort); 
            rs = ps.executeQuery();

            while (rs.next()) {
                vo = new RoomVO();
                vo.setRoomNum(rs.getInt("roomNum"));
                vo.setRoomName(rs.getString("roomname"));
                vo.setRoomType(rs.getString("ROOMTYPE"));
                vo.setViewType(rs.getString("viewType"));
                vo.setInventory(rs.getInt("inventory"));
                vo.setRoomCapacity(rs.getInt("roomCapacity"));
                vo.setRoomPrice(rs.getInt("roomPrice"));
                vo.setImg(rs.getString("img"));

                list.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, ps, rs);
        }
        return list;
    }

    // 높은 가격순으로 방 정보를 가져오는 메서드
    public List<RoomVO> getRoomsOrderByHighestPrice(String viewType, String roomType) throws SQLException {
        List<RoomVO> list = new ArrayList<>();
        String sql = "SELECT * FROM room WHERE ROOMTYPE = ? AND VIEWTYPE = ? ORDER BY ROOMPRICE DESC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        RoomVO vo = null;

        try {
            conn = DBManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, roomType);
            ps.setString(2, viewType);
            rs = ps.executeQuery();

            while (rs.next()) {
                vo = new RoomVO();
                vo.setRoomNum(rs.getInt("roomNum"));
                vo.setRoomName(rs.getString("roomname"));
                vo.setRoomType(rs.getString("ROOMTYPE"));
                vo.setViewType(rs.getString("viewType"));
                vo.setInventory(rs.getInt("inventory"));
                vo.setRoomCapacity(rs.getInt("roomCapacity"));
                vo.setRoomPrice(rs.getInt("roomPrice"));
                vo.setImg(rs.getString("img"));

                list.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, ps, rs);
        }
        return list;
    }
	
}//end
