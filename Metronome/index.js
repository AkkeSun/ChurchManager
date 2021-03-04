<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>I got Rhythm</title>
	
	<!-- bootstrap -->
	<link  href="./css/bootstrap.min.css"  rel="stylesheet"  type="text/css">
	
	<!-- 커스텀 CSS -->
	<link  href="./css/mySet.css"  rel="stylesheet"  type="text/css">
	
</head>

<body>
		<div class="container-fluid">
		<header>	
		<h1 class="mycol headFont py-3 mt-3 text-center" id=h>I got Rhythm</h1>    
		</header>
		
		<div class=row>
			<div class=col>
				<input type=text id=tempo value=60 class='bg-warning text-center mytempo form-control w-100 h-100'>
  			</div>
  			<div class=col>
  			  	<button class="btn btn-warning w-100 mybutton" onclick='tempo(0)'>UP</button>
  				<button class="btn btn-warning w-100 mybutton" onclick='tempo(1)'>DOWN</button>
 			</div>
 		</div>
		
		
		<!-- 플레이버튼(이미지) -->
		<img src="./Images/main.jpg" id=myImg class="w-100 mt-2" 
		onclick="play()" onmouseover="changeImg(0)" onmouseout="changeImg(1)">


		
		<!-- footer -->
		<footer class="text-center mycol py-2 myfooter">
			.Copylight 2020.선양 All rights reserved.
		</footer>
		
		</div>
		
<script>

	let check = false; // play버튼 체크용
	let sound = 0;     
	let audio = new Audio('./sound/CN.wav');
	let backImg = document.getElementById('myImg');
	let num = 0; 

	
	//커서를 갖다대면 이미지가 바뀐다
	function changeImg ( n ) {
		// 실행증이 아니라면
		if(check==false){
			if(n==0){
				backImg.src= "./Images/play.jpg";
			}else if (n==1){
				backImg.src= "./Images/main.jpg";
			}
		
		// 실행중이라면
		}else if(check==true){
			if(n==0){
				backImg.src= "./Images/stop.jpg";
			}else if (n==1){
				backImg.src= "./Images/main2.jpg";
			}
		}
	}

	
	
	
	
	//템포 Up & Down 버튼
	function tempo( n ) {
		
		let tempo = document.getElementById('tempo').value;
	
		if(n==0) {
			tempo = parseInt(tempo)+1;;
			document.getElementById('tempo').value = tempo;
		
		}else if (num==1){
			tempo = parseInt(tempo)-1;
			document.getElementById('tempo').value = tempo;
		}
		
		//tempo가 0이되면 안된다
		if(tempo==0){
			alert('더이상 내려갈 수 없습니다');
			document.getElementById('tempo').value = 60;
			return;
		}
	}
	
	
	
	
	//Play 
	function play(){
		
		if(check==false){
			check = true;
			num=0;
			let tempo = document.getElementById('tempo').value;
			let input = Math.ceil(60000/parseInt(tempo));
			sound = setInterval(PlayMet, input); 
			
		//플레이 중이라면	
		} else {
			check=false;
			clearInterval(sound);
			document.getElementById('h').innerHTML = 'I got Rhythm';
			backImg.src = "./Images/main.jpg";
		}
	}
	
	
	
	function PlayMet(){	
		num++;
		if(num>4){num=1};
		document.getElementById('h').innerHTML ="PLAY " + num + " PLAY";
		audio.play();
		backImg.src = "./Images/main2.jpg";
	}
	
	
</script>		



</body>
</html>
