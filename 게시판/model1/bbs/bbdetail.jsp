<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dto.MemberDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
//session 값 가져오기
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
int seq = Integer.parseInt(request.getParameter("seq"));
BbsDao dao = BbsDao.getInstance();
BbsDto d = dao.detailList(seq);

//readcount 불러오기
dao.readcount(seq); // 창 열 때마다 readcount가 1씩 늘어남

%>
	
	
<br><br><br><br>
<div align=center>
<form id=frm>
<table border=1>
<col width='70'><col width='600'>
<tr>
	<th>작성자</th>
	<td><%=mem.getId() %></td>
</tr>
<tr>
	<th>작성일</th>
	<td><%=d.getWdate() %></td>
</tr>
<tr>
	<th>제목</th>
	<td><%=d.getTitle() %></td>
</tr>
<tr>
	<th>조회수</th>
	<td><%=d.getReadcount() %></td>
</tr>
<tr>
	<th>정보</th>
	<td><%=d.getRef() %>-<%=d.getStep() %>-<%=d.getDepth() %> (ref-step-depth)</td>
</tr>
<tr>
	<th>내용</th>
	<td style='height:500px'><%=d.getContents() %></td>
</tr>
<tr>
<td></td>
<td>
<button type=button id=btn1>글목록</button>

<%
//작성자와 로그인 한 사람이 같다면
if(d.getId().equals(mem.getId())){
	%>	
	<button type="button" id=btn2>수정</button>
	<button type="button" id=btn3>삭제</button>
	<%
}
%>
<button type=button id=btn4>댓글</button>

<td>

</tr>
</table>
<input type=hidden id=hdn name=hdn>
</form>
</div>
	
	
<script>

$(document).ready(function () {
	
	$('#btn1').click(function () {
		location.href="bbslist.jsp";
	});
	
	$('#btn2').click(function () {
		location.href="bbsfix.jsp?seq="+ <%=seq%>;
	});
	
	$('#btn3').click(function () {
		location.href="bbsdelete.jsp?seq="+ <%=seq%>;
	});
	
	$('#btn4').click(function () {
		location.href="bbsanswer.jsp?seq="+ <%=seq%>;
	});
	
	
});


</script>	
	
	
	


</body>
</html>
