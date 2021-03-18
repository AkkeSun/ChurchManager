<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

MemberDao dao = MemberDao.getInstance();

//dto를 매개변수로 받고 유효성 검사 후 dto를 다시 내보낸다.
MemberDto dto = dao.login(new MemberDto(id, pwd, null, null, 0));

if(dto != null && !dto.getId().equals("")){
	
	// session에 로그인 정보 저장 (계속 가지고 다니기)
	session.setAttribute("login", dto);
	
	%>
	<script type="text/javascript">
	alert("안녕하세요 <%=dto.getId() %>님");
	location.href = "bbslist.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("id나 password를 확인하세요");
	location.href = "login.jsp";
	</script>
	<%
}
%>


</body>
</head>
