<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/passcheck.css">
<script src="js/ReservationCheck.js" type="text/javascript"></script>
</head>
<body>
<div align="center">
	<h1>예약 비밀번호 확인</h1>
	<form action="HotelServlet" name="frm" method="get">
		<input type="hidden" name="command" value="Reservation_check_pass">
		<input type="hidden" name="num" value="${param.num}"> <%-- request.getParameter => param --%>
		<br>
		<br>
		<table style="width: 80%">
			<tr>비밀번호</tr>
			<td><input type="password" name="pass" size="20"></td>
		</table>
		<br>
	<div class = "button">
		<input type="submit" value="확인" onclick="return ReservationPassCheck()">
	</div>
		<br><br>${message}
	</form>
</div>

</body>
</html>