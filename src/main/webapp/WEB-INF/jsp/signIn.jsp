<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>

  <!-- Custom styles for this template -->
  <link href="css/signin.css" rel="stylesheet">
</head>

<body class="text-center">

  <main class="form-signin">
    <form action="/HouseShip/signinPage" method="post">
      <!-- <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
      <h1 class="h3 mb-3 fw-normal">管理系統登入</h1>

      <div class="form-floating">
        <input type="text" class="form-control" id="floatingInput" name="username" placeholder="帳號">
        <label for="floatingInput">帳號</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="密碼">
        <label for="floatingPassword">密碼</label>
        <input type="checkbox" name="remember-me">RememberMe
      </div>
      <div>
      	<p>${requestScope.errorMes}</p>
      </div>

      <!-- <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> 保持登入
        </label>
      </div> -->
      <button class="w-100 btn btn-lg btn-primary" type="submit" value="login">Login</button>
     
      <p class="mt-5 mb-3 text-muted">&copy; 2022–2028</p>
    </form>
  </main>

</body>

</html>