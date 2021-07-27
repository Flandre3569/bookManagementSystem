<%--
  Created by IntelliJ IDEA.
  User: 13088
  Date: 2021/6/22
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图书管理系统</title>
    <link rel="stylesheet" href="login-index.css">
</head>
<body>
<div class="web_body">
       <span class="web_font">
           Welcome to Book management system
       </span>
    <div>
        <a  class="blog_login">Login in</a>
        <a  class="blog_register">register</a>
    </div>
</div>

<!--    登入页面-->
<form action="login" method="post">
    <div id="login" class="login">
        <div id="title" class="login-title">Login
            <span><a id="closeBtn" href="javascript:void(0);" class="close-login">关闭</a></span>
        </div>
        <div class="login-input-content">
            <div class="login-input">
                <label>用户名：</label>
                <input type="text" placeholder="请输入用户名" name="username" id="username" class="list-input">
            </div>
            <div class="login-input">
                <label>登录密码：</label>
                <input type="password" placeholder="请输入登录密码" name="password" id="password" class="list-input">
            </div>
            <p style="color: red ;size: 10px">&nbsp;&nbsp;${msg}</p>
        </div>
        <div class="login-select">
            <select name="identity" id="identity">
                <option value="用户">用户</option>
                <option value="管理员">管理员</option>
            </select>
        </div>
        <div id="loginBtn" class="login-button"><input type="submit" id="login-button-submit" value="登入"></div>
    </div>
</form>
<!--    注册页面-->
<form action="register" method="post">
    <div id="register" class="register">
        <div id="title_register" class="register-title">Register
            <span><a id="closeBtn_register" href="javascript:void(0);" class="close-register">关闭</a></span>
        </div>
        <div class="register-input-content">
            <div class="register-input">
                <label>用户名：</label>
                <input type="text" placeholder="请输入用户名" name="username2" id="username2" class="list-input">
            </div>
            <div class="register-input">
                <label>登录密码：</label>
                <input type="password" placeholder="请输入登录密码" name="password2" id="password2" class="list-input">
            </div>
            <p style="color: red ;size: 10px">&nbsp;&nbsp;${msg2}</p>
        </div>
        <div id="loginBtn_register" class="register-button"><input type="submit" id="register-button-submit2" value="注册"></div>
    </div>
</form>
<!-- 遮盖层 -->
<div id="bg" class="login-bg"></div>

<script>
    //实现点击弹出模态框的效果
    let login=document.querySelector('.login');
    let mask=document.querySelector('.login-bg');
    let link=document.querySelector('.blog_login');
    let closebtn=document.querySelector('#closeBtn');
    let title=document.querySelector('#title');
    let register=document.querySelector('.register');
    let link2=document.querySelector('.blog_register');
    let closeBtn_register=document.querySelector('#closeBtn_register');
    let title_register=document.querySelector('#title_register');
    link.addEventListener('click',function(){
        mask.style.display='block';
        login.style.display='block';
    })
    link2.addEventListener('click',function (){
        mask.style.display='block';
        register.style.display='block';
    })

    closeBtn.addEventListener('click',function(){
        mask.style.display='none';
        login.style.display='none';
    })
    closeBtn_register.addEventListener('click',function (){
        mask.style.display='none';
        register.style.display='none';
    })
    //实现拖拽效果
    title.addEventListener('mousedown',function(e){
        let x=e.pageX-login.offsetLeft;
        let y=e.pageY-login.offsetTop;
        document.addEventListener('mousemove',fn);
        function fn(e){
            login.style.left=e.pageX-x+'px';
            login.style.top=e.pageY-y+'px';
        }
        document.addEventListener('mouseup',function(){
            document.removeEventListener('mousemove',fn);
        })
    })
    //实现注册框的拖拽效果
    title_register.addEventListener('mousedown',function (e){
        let x=e.pageX-register.offsetLeft;
        let y=e.pageY-register.offsetTop;
        document.addEventListener('mousemove',fn);
        function fn(e){
            register.style.left=e.pageX-x+'px';
            register.style.top=e.pageY-y+'px';
        }
        document.addEventListener('mouseup',function(){
            document.removeEventListener('mousemove',fn);
        })
    })
</script>
</body>
</html>
