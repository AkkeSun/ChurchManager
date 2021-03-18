<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>


<%

String title = request.getParameter("title");
String contents = request.getParameter("contents");
int seq = Integer.parseInt(request.getParameter("seq"));


BbsDao dao = BbsDao.getInstance();
boolean b = dao.fixBbsList(title, contents, seq);

	if(b==true){
		%>
		<script>
		alert("성공적으로 수정되었습니다");
		location.href="bbslist.jsp";
		</script>
		<%
	} else {
		%>
		<script>
		alert("수정에 실패했습니다");
		location.href="bbslist.jsp";
		</script>
		<%
	}
%>


</body>
</html>
