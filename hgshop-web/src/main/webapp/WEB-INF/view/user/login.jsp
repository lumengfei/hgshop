<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title></title>

   
    <!-- Bootstrap core CSS -->
<link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >

    <!-- Favicons -->
<link rel="apple-touch-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="https://v4.bootcss.com/docs/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon.ico">
<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap4/js/bootstrap.js"></script>
<meta name="msapplication-config" content="/docs/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c">
<script type="text/javascript" src="https://cdn.bootcss.com/blueimp-md5/2.11.1/js/md5.js"></script>
	


 <script type="text/javascript">
 	function toRegister(){
 		location="toRegister"
 	}
 
/* function login(){
	alert($("[name=name]").val())
	alert(md5($("[name=name]").val()))
	$("#mi").val(md5($("[name=name]").val()))
} */
</script> 

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="/resource/css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <form class="form-signin" action="login" method="post">
  <img class="mb-4" src="login_files/bootstrap-solid.svg" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">请登录</h1>
  <label for="inputEmail" class="sr-only">用户名</label>
  <input type="text"  name="username" id="inputEmail" class="form-control" placeholder="用户名" required="" autofocus="">
  <label for="inputPassword" class="sr-only">密码</label>
  <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required="">
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> 下次直接登录
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block"   type="submit">登录</button>
  <button class="btn btn-lg btn-primary btn-block"  onclick="toRegister()"  type="button">注册</button>
  <p class="mt-5 mb-3 text-muted">© 2017-2020</p>
</form>


</body></html>