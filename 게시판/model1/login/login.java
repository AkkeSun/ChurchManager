<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.mainText{font-size:70px;}	
</style>

<!-- Jquary -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!--Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- Sweet Alert -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


<!-- Cookie -->
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

</head>
<body>
<div align="center" style="margin-top: 200px; px-5">

<div class="row mb-3">
	<div class=col-sm-4></div>
	<div class=col-sm-4><h2 class=mainText>login page</h2></div>
	<div class=col-sm-4></div>
</div>
<form action="loginAF.jsp" method="post">
<div class='row mb-1'>
	<div class=col-sm-4></div>
	<div class=col-sm-4><input type="text" class="form-control" id="_id" name="id" placeholder='user id'></div>
	<div class=col-sm-4></div>
</div>
<div class='row mb-2'>
	<div class=col-sm-4></div>
	<div class=col-sm-4 align=left>
	<input type="checkbox" id="chk_save_id" class="btn btn-secondary" autocomplete=off>
	<span style=font-size:13px>SAVE ID</span></div>
	<div class=col-sm-4></div>
</div>
<div class='row mb-3'>
	<div class=col-sm-4></div>
	<div class=col-sm-4><input type="password" class="form-control" name="pwd" size="20" placeholder='user password'></div>
	<div class=col-sm-4></div>
</div>
<div class=row>
	<div class="col-sm-4 ml-3"></div>
	<input type="submit" value="로그인" class="btn btn-info">
	<button type="button" onclick="account()" class="btn btn-info ml-1" >회원가입</button>
	<div class=col-sm-4></div>
</div>
</form>

</div>



<script type="text/javascript">
function account() {	
	location.href = "regi.jsp";
}


// 쿠키 저장 
let user_id = $.cookie("user_id");

// 저장된 id가 있다면
if(user_id != null){	
	$("#_id").val( user_id ); //id창에 쿠키를 보이게 해라
	$("#chk_save_id").attr("checked", "checked"); //체크 버튼을 체크해라
}

// 체크버튼을 누른다면
$("#chk_save_id").click(function() {
	
	// 체크 처리 
	if( $("#chk_save_id").is(":checked") ){ 
		//아이디를 입력 안했다면
		if( $("#_id").val().trim() == "" ){
			swal({
		    	  title: "ID를 입력해주세요",
		    	  icon: "error",     //error
		    	  button: "OK", //버튼에 들어갈 이름
		    });
			
			
		//아이디를 입력했다면
		}else{
			// 쿠키를 저장 (k:v)                                                                             //유지기간(일)  //전역에 걸쳐 저장
			$.cookie("user_id", $("#_id").val().trim(), { expires:7, path:'./'});
		}
	}
	
	//체크해제한다면 (쿠키에서 제거 ->  유지기간 삭제)
	else{                      
		$.removeCookie("user_id", { path:'./' });
	}
	
}); 

</script>

</body>
</html>
