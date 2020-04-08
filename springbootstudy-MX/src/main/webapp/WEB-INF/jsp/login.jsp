<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>系统登录</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/mx-login.css"/>
</head>
<body>
<div class="body-main">
  <div class="login-main">
    <h1>系统登录</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
      <div>
        <input type="text" placeholder="输入帐号" id="userLoginId" name="userLoginId">
      </div>
      <div>
        <input type="password" id="currentPassword" name="currentPassword" placeholder="输入密码">
      </div>
      <div class="errormsg">
        &nbsp;${msg}
      </div>
      <div class="btn_login">
        <input type="submit" value="登录">
      </div>
      <div>
        &nbsp;
      </div>
    </form>
  </div>
</div>
</body>
</html>
