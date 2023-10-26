<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	if (window.name = "admin"){
		window.opener.parent.location.href = "HotelServlet?command=QnA_reply_form_admin&num=${param.num}";
		
	}
	window.close();
	</script>
</body>
</html>