<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//로그인 정보 값 가져오기
Object ologin = session.getAttribute("login");
MemberDto mem = (MemberDto)ologin;
%>            
    
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




BbsDto bbs = new BbsDto(mem.getId(), title, contents);
BbsDao dao = BbsDao.getInstance();
boolean b = dao.addBbsList(bbs);
	if(b==true){
		%>
		<script>
		alert("성공적으로 추가되었습니다");
		location.href="bbslist.jsp";
		</script>
		<%
	} else {
		%>
		<script>
		alert("추가에 실패했습니다");
		location.href="bbswrite.jsp";
		</script>
		<%
	}
%>


</body>
</html>
