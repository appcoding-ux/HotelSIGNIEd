<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 조회</title>
    <link rel="stylesheet" href="css/Reservation.css">
    <script type="text/javascript" src="js/ReservationCheck.js"></script>
    
</head>
<body>

    <h2>예약 조회</h2>
    <form name="frm" method="post" action="HotelServlet">
        <input type="hidden" name="command" value="Reservation_Num">
    <div class="col-box">   
        <label for="inp-num" class="input-title">온라인 예약번호*</label><br>
        <input class="reservationBox" type="text" name="num" size ="20" title="예약번호" placeholder="예약 번호를 입력하세요.">
    <div>   
        
            <button type="submit"  name="confirm" value="확인" onclick="return ReservationCheck()">
            <span>확인</span>
            </button>
             <br><br>${message}
	</form>
</body>
</html>                               