<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<link rel="stylesheet"
	href="hotel-datepicker-main/dist/css/hotel-datepicker.css">
<script src="hotel-datepicker-main/dist/fecha.js"></script>
<script src="hotel-datepicker-main/fecha-4.2.1/dist/fecha.min.js"></script>
<script src="hotel-datepicker-main/dist/js/hotel-datepicker.js"></script>
<link rel="stylesheet" href="css/search.css">
<script src="js/detailSearch.js"></script>
<!-- 이거 폰트어썸 스크립트로 아이콘 쓸 수 있는 스크립트입니다. -->
<script src="https://kit.fontawesome.com/f21f7d3508.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap"
	rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<div class="header">
			<a href="index.jsp"><img src="hotel_logo.png" alt="호텔로고사진"></a>

			<nav>
				<ul>
					<li class="sertchClick"><a href="">객실예약</a></li>
					<li><a href="">예약조회</a></li>
					<li><a href="">QnA</a></li>
				</ul>
			</nav>
			<div class="sertchWrap">
				<div class="hotelSertch">
					<form action="HotelServlet" name="frm" method="post" id="myForm">
						<input type="hidden" name="command" value="Reservation_save"
							class="command" /> <input type="hidden" name="originCheckIn"
							value="${originCheckIn}" /> <input type="hidden"
							name="originCheckOut" value="${originCheckOut}" />
						<div class="hotelName">
							<label for="name">호텔</label>
							<div class="input">
								<input type="text" readonly="readonly" value="시그니드 서울"
									name="name" id="name">
							</div>
						</div>
						<div class="hotelCheckinAndCheckout">
							<div class="date_col">
								<strong class="date_title">체크인</strong> <span class="date_day">${checkIn}</span>
							</div>
							<span class="date_stay"> <span class="night">${bak}</span>
							</span>
							<div class="date_col">
								<strong class="date_title">체크아웃</strong> <span class="date_day">${checkOut}</span>
							</div>

							<a href="" title="레이어팝업" class="date_anchor"></a>
						</div>
						<div class="sertchPerson">
							<div class="person_col">
								<strong class="person_text">객실수</strong> <span
									class="person_num">1</span>
							</div>
							<div class="person_col">
								<strong class="person_text">성인</strong> <span class="person_num">${adult}</span>
							</div>
							<div class="person_col">
								<strong class="person_text">어린이</strong> <span
									class="person_num">${child}</span>
							</div>

							<a href="" title="레이어팝업" class="date_anchor"></a>
						</div>
						<div class="item_edit">
							<button type="submit" class="sertchButton" onclick="">수
								정</button>
						</div>

						<div class="dateInput">
							<div>
								<input type="hidden" id="input-id" name="input-id"
									placeholder="Enter ID">
							</div>

							<div class="datePerson">
								어른
								<!-- 어른의 수를 조절하는 input -->
								<input type="button" value=" - " onclick="del('adultAmount')"
									class="amounts"> <input type="text" name="adultAmount"
									id="adultAmount" value="${adult}" min="1" size="3"> <input
									type="button" value=" + " onclick="add('adultAmount')"
									class="amounts"> &nbsp;&nbsp;&nbsp; 어린이
								<!-- 어린이의 수를 조절하는 input -->
								<input type="button" value=" - " onclick="del('childAmount');"
									class="amounts"> <input type="text" name="childAmount"
									id="childAmount" value="${child}" size="3"> <input
									type="button" value=" + " onclick="add('childAmount');"
									class="amounts">
							</div>

						</div>
					</form>
				</div>

			</div>
		</div>

		<!-- 10/27 href 이동은 페이지가 만들어지고 수정 -->
		<div class="stepProcess">
			<div class="process_col">
				<span class="on_text">1) 객실선택</span>
			</div>
			<div class="process_col">
				<span class="off_text">——— 2) 옵션선택</span>
			</div>
			<div class="process_col">
				<span class="off_text">——— 3) 예약정보 입력</span>
			</div>
		</div>

		<div class="searchList">
			<div class="searchListImg">
				<a href="" id="show"><img src="./search_icon/detailSearch.ico"
					alt="detailSearch" width="35" height="35"> <span
					class="searchListP">상세검색</span> </a>
			</div>
		</div>

		<div class="roomList">

			<c:forEach var="room" items="${roomList }">
				<input type="hidden" name="roomNum" value="${room.roomNum}"
					id="roomNum" />
				<input type="hidden" name="roomName" value="${room.roomName}"
					id="roomName" />
				<input type="hidden" name="roomPrice" value="${room.roomPrice}"
					id="roomPrice" />
				<div class="record">
					<div class="roomImg">
						<img src="${room.img}" />
					</div>
					<div class="room_info">
						<a href="HotelServlet?command=room_list&num=${room.roomNum}">${room.roomName}</a>
						<p>침대타입 ${room.roomType}</p>
						<p>침대타입 ${room.roomType}</p>
						<p>
							<fmt:formatNumber type="currency" value="${room.roomPrice}"
								currencySymbol="￦" />
						</p>
						<button type="submit" form="myForm" onclick="submitForm()">예약하기</button>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<div class="background">
		<div class="detailSearch">
			<form action="HotelServlet" name="frm" method="post">
				<input type="hidden" name="command" value="detial_search"
					class="command" />
				<!-- modal : 팝업창, 일단 modal창 크게 wrap 하는 코드  -->
				<div class="detailSearch-modal-wrap" role="document">

					<!-- header : 객실 필터 div title로 객실 필터, 창을 닫는 x버튼을 우측 상단에 만들어서 css값이 리셋이 될 수 있도록 작성 -->
					<header class="detailSearch-modal-head">
						<h2 class="detailSearch-modal-title">객실필터</h2>
						<!-- ??? 닫기버튼 어떻게 -->
						<button type="button" class="closeButton"
							onclick="closeButton('.background')">
							<i class="fa-solid fa-xmark"></i>
						</button>
					</header>

					<div class="detailSerach-modal-body">
						<!-- body영역 정렬 기준 : 낮은 가격순, 높은 가격순 = 가격을 가져와서 asc, desc 하는 정렬 sql구문을 사용해서 정렬해준다.
                  오름 차순 : ASC 내림차순 : DESC -->
						<div class="column-group">
							<div class="column">
								<p class="title">정렬기준</p>
								<div class="price-btn-area">
									<div class="price-btn">
										<input type="radio" id="radio-box01" name="fee" value="asc"
											checked="checked"> <label for="radio-box01" class="">낮은
											가격 순</label>
									</div>
								</div>
								<div class="price-btn">
									<input type="radio" id="radio-box02" name="fee" value="desc">
									<label for="radio-box02" class="">높은 가격 순</label>
								</div>
							</div>


							<div class="column">
								<!-- 뷰타입 : 오션, 시티, 하버
               = viewtype을 select해서 DB에서 조건에 맞는 내용을 가져와서 [???]값에 저장  -->

								<p class="title">뷰타입</p>
								<div class="view-btn-area">
									<div class="view-btn">
										<input type="checkbox" id="check-box01" name="view">
										<label for="radio-box01" class="">시티뷰</label>
									</div>
									<div class="view-btn">
										<input type="checkbox" id="check-box02" name="view">
										<label for="radio-box02" class="">오션뷰</label>
									</div>
									<div class="view-btn">
										<input type="checkbox" id="check-box03" name="view">
										<label for="radio-box03" class="">하버뷰</label>
									</div>
								</div>
							</div>

							<div class="column">
								<p class="title">침대 타입</p>
								<!-- 근데 이거 다중선택하게 어떻게 함? -->
								<div class="room-btn-area">
									<div class="room-btn">
										<input type="checkbox" id="check-box01" name="room"> <label
											for="radio-box01" class="">더블</label>
									</div>
									<div class="room-btn">
										<input type="checkbox" id="check-box02" name="room"> <label
											for="radio-box02" class="">트윈</label>
									</div>
									<div class="room-btn">
										<input type="checkbox" id="check-box03" name="room"> <label
											for="radio-box03" class="">패밀리</label>
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="detailSerach-modal-foot">
							<button type="reset" onclick="">초기화</button>
							<button type="submit" onclick="">검색</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>