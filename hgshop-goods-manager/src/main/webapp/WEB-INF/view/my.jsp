<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript" src="https://cdn.bootcss.com/jsSHA/2.3.1/sha.js"></script>
</head>
<script type="text/javascript">
	
		
	
	
	
	function ddd(){
			var v = $("#text").val();
			alert(v)
			sha =new jsSHA("SHA-1","TEXT",{numRounds:1});
			sha.update(v);
			v = sha.getHash("HEX");
			alert(v)
			$("#test1").val(v)
			location="/my/ssss?msg="+$("#text").val()+"          "+v
	}
</script>
<body>
        <input type="text" id="text">
        <button id="myButton"  onclick="ddd()">提交</button>
        
        <div style="width: 250px;height: 250px;">
        <textarea id="test1" rows="10" cols="10">
        
        </textarea>
        </div>
</body>
</html>