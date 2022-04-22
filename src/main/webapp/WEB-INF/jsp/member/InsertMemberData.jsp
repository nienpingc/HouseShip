<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增會員</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style type="text/css">
	.div1{
		border:2px solid #0B1A4A;
		border-radius:20px;
		width:600px;
		margin: 50px auto;
	}
	.head2{
		margin: 20px auto;
		text-align: center;
	}
	.divForm{
		width: 500px;
		margin: 20px auto;
		text-align: left;
	}
	.divInput{
		margin: 10px auto;
		text-align: center;
	}input{
		width:250px;
	}td,th{
		width:250px
	}.btn{
		width:100px;
	}
</style>
</head>
<body>
	<div class="div1">
	<h2 class="head2">新增會員</h2>
	<div class="divForm">
	<form action="insertmember.controller" method="post">
		帳號<input class="form-control" type="text" name="account" required placeholder="必填"><br>
		密碼<input class="form-control" type="text" name="hashed_pwd" required placeholder="必填"><br>
		鹽值<input class="form-control" type="text" name="salt"  value="" required placeholder="必填"><br>
		姓<input class="form-control" type="text" name="firstname"  value="" required placeholder="必填"><br>
		名<input class="form-control" type="text" name="lastname" value=" " required placeholder="必填"><br><br>
		生日<input class="form-control" type="date" name="birthday" value=" " required placeholder="必填"><br><br>
		e-mail<input class="form-control" type="text" name="email" value=" " required placeholder="必填"><br><br>
		聯絡地址<input class="form-control" type="text" name="m_address" value=" " placeholder="選填"><br><br>
		聯絡電話<input class="form-control" type="text" name="phone" value=" " required placeholder="必填"><br><br>
		頭像<input class="form-control" type="text" name="mempic" value=" " placeholder="選填"><br><br>
		<div class="divInput">
			<input type="submit" class="btn btn-primary" name="insert" value="送出">
		</div>
	</form>
	</div>
	</div>
	<div class="divInput">
			<a href="/HouseShip/member"><input type="submit" class="btn btn-secondary" value="取消"></a>
	</div>
	
	<script>
		document.getElementById("chkin").addEventListener("change",dateSet);
		document.getElementById("chkin").addEventListener("blur",dateSet);
		document.getElementById("chkout").addEventListener("focus",dateSet);
		function dateSet(){
			var inDateVal = document.getElementById("chkin").value;
  			var outDate = document.getElementById("chkout");
 			outDate.setAttribute("min", inDateVal);
		}
	</script>
</body>
</html>