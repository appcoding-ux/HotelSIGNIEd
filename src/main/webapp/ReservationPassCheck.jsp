<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="js/ReservationCheck.js" type="text/javascript"></script>
</head>
<body>
<div align="center">
	<h1>���� ��й�ȣ Ȯ��</h1>
	<form action="HotelServlet" name="frm" method="get">
		<input type="hidden" name="command" value="Reservation_check_pass">
		<input type="hidden" name="num" value="${param.num}"> <%-- request.getParameter => param --%>
		<br>
		<br>
		<table style="width: 80%">
			<tr>��й�ȣ</tr>
			<td><input type="password" name="pass" size="20"></td>
		</table>
		<br>
		<input type="submit" value="Ȯ��" onclick="return ReservationPassCheck()">
		<br><br>${message}
	</form>
</div>

</body>
</html>