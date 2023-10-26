<%@page import="com.signied.dto.ReservationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 정보 조회</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/Reservation.css">
<link rel="stylesheet" href="css/ReservationTable.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<link rel="stylesheet"
	href="hotel-datepicker-main/dist/css/hotel-datepicker.css">
<script src="hotel-datepicker-main/dist/fecha.js"></script>
<script src="hotel-datepicker-main/fecha-4.2.1/dist/fecha.min.js"></script>
<script src="hotel-datepicker-main/dist/js/hotel-datepicker.js"></script>
<script src="js/sertch.js"></script>
<script src="js/ReservationCheck.js" type="text/javascript"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap"
	rel="stylesheet">    
</head>
<body>
<jsp:include page="header.jsp" />
<h3 class="info-title">예약 정보</h3>

<%
    ReservationVO reservation = (ReservationVO) request.getAttribute("reservation");

    if (reservation != null) {
%>
    <table>
        <tr>
            <th>예약번호</th>
            <th>이메일</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>Check-In</th>
            <th>Check-Out</th>
            <th>인원수</th>
            <th>조식인원</th>
            <th>객실고유번호</th>
        </tr>
        <tr>
            <td><%= reservation.getReserveNum() %></td>
            <td><%= reservation.getReserveEmail() %></td>
            <td><%= reservation.getReserveName() %></td>
            <td><%= reservation.getReservePhone() %></td>
            <td><%= reservation.getCheckIn() %></td>
            <td><%= reservation.getCheckOut() %></td>
            <td><%= reservation.getGuestNum() %></td>
            <td><%= reservation.getBreakfast() %></td>
            <td><%= reservation.getRoomNum2() %></td>
        </tr>
    </table>
<%
    } else {
%>
    <p>예약 내역이 존재하지 않습니다.</p>
<%
    }
%>

</body>
</html>
