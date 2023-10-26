<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 조회</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/Reservation.css">
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
	<div style="margin:300px auto 0; width: 1320px;  position:relative; z-index:1000;">
		<h2>예약 조회</h2>
		<h5>객실 조회</h5>

		<form name="frm" method="post" action="HotelServlet">
			<input type="hidden" name="command" value="Reservation_Num">
			<div class="col-box">
				<label for="num" class="input-title">온라인 예약번호*</label><br>
				<input class="reservationBox" type="text" name="num" size="20"
					title="예약번호" placeholder="예약 번호를 입력하세요." id="num">
				<button type="submit" name="confirm" value="확인"
					onclick="return ReservationCheck()" class="submitButton">
					<span>확인</span>
				</button>
				<br> <br>${message}
			</div>
		</form>
	</div>
</body>
</html>
