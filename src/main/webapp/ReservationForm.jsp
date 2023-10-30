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
	<div
		style="margin: 300px auto 0; width: 1320px; position: relative; z-index: 1000;">

		<form name="frm" method="post" action="HotelServlet">
			<input type="hidden" name="command" value="Reservation_save">

			<div class="reservation-room-info">
				<div class="img-area m-none">
					<img src="image/karina.png" alt="karina">

					<div class="txt-area">
						<li><span class="type f-bold">호텔 및 객실</span> <span
							class="info htlAndRms">그랜드 디럭스 더블 시티뷰</span></li>

						<li><span class="type f-bold">투숙 날짜</span> <span class="info">
								<span data-target="conversionDateFormat">2023년 10월 30일</span> -
								<span data-target="conversionDateFormat">2023년 10월 31일</span> (1
								<span class="night-days" data-rdays="1">박</span>)
						</span></li>
						<li><span class="type f-bold">객실 및 인원</span> <span
							class="info">객실 1, 성인 2, 어린이 0</span></li>

					</div>
				</div>

				<div class="totalprice">
					<span class="total-price">총 요금</span> <span class="total-number">1000000</span>


				</div>

			</div>

			<div class="reservation-title">
				<h3>예약자 정보</h3>

			</div>

			<div class="col-box">
				<label for="name" class="input-title">예약자 이름 *</label><span></span><br>
				<input class="reservationBox" type="text" name="name" size="20"
					title="예약자 이름" placeholder="예약자 이름을 입력하세요." id="name" required>
				<hr class="inquiry-hr">

				<label for="phone" class="input-title">예약자 전화번호 *</label><br> <input
					class="reservationBox" type="text" name="phone" size="20"
					title="예약자 전화번호" placeholder="ex)010-****-****" id="phone" required>

				<hr class="inquiry-hr">

				<label for="email" class="input-title">예약자 이메일 *</label><br> <input
					class="reservationBox" type="text" name="email" size="20"
					title="예약자 이메일" placeholder="ex)abc@naver.com" id="email" required>
			</div>

			<button type="submit" name="confirm" value="확인"
				onclick="return ReservationValue()" class="submitButton">
				<span>확인</span>
			</button>


		</form>
	</div>



</body>
</html>