<%@ page import="com.mx.BookSystem.bean.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mx.BookSystem.bean.User" %>
<%@ page import="com.mx.BookSystem.bean.Borrow" %><%--
  Created by IntelliJ IDEA.
  User: Fan
  Date: 2021/6/19
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
    <link rel="stylesheet" href="./User_index_style.css">
  </head>
  <body>
  <div class="container">
    <header class="header">
      <span>管理界面</span>
      <h1>用户信息管理界面</h1>
      <img src="./images/左箭头.png" alt="" class="arrow">
    </header>

    <div class="box">
      <img src="./images/设置2.png" alt="" class="btn">
    </div>

    <%
      List<Borrow> borrows = (List<Borrow>) session.getAttribute("borrows");
    %>
    <div class="main">
      <div class="content" id="box1">
        <p style="font-size: 50px;color: white">你好，用户${userId}。</p>
        <p style="font-size: 50px;color: white">您已经借阅了${bookNum}本书。</p>
        <table class="table_container" id="">
          <tr>
            <td>用户名</td>
            <td>图书ID</td>
            <td>图书名称</td>
            <td>作者</td>
            <td>借书时间</td>
            <td>还书时间</td>
          </tr>
          <%for (Borrow borrow:borrows) {%>
          <tr>
            <td><%=borrow.getUserId()%></td>
            <td><%=borrow.getBookId()%></td>
            <td><%=borrow.getBookName()%></td>
            <td><%=borrow.getAuthor()%></td>
            <td><%=borrow.getBorrowTime()%></td>
            <td><%=borrow.getReturnTime()%></td>
          </tr>
          <%}%>
        </table>
      </div>
    </div>
  </div>

  <form action="change" method="post">
    <div id="login" class="login">
      <div id="title" class="login-title">Modify the password
        <span><a id="closeBtn" href="javascript:void(0);" class="close-login">关闭</a></span>
      </div>
      <div class="login-input-content">
        <div class="login-input">
          <label>输入旧密码：</label>
          <input type="text" placeholder="请输入旧密码" name="oldPwd" id="username" class="list-input">
        </div>
        <div class="login-input">
          <label>输入新密码：</label>
          <input type="password" placeholder="请输入新密码" name="newPwd" id="password" class="list-input">
        </div>
        <p style="color: red ;size: 10px">&nbsp;&nbsp;${message}</p>
      </div>
      <div id="loginBtn" class="login-button"><input type="submit" id="login-button-submit" value="提交"></div>
    </div>
  </form>
  <!-- 遮盖层 -->
  <div id="bg" class="login-bg"></div>
    <script>
      let arrow=document.querySelector('.arrow');
      arrow.addEventListener('click',function (){
          window.location.href='./index.jsp';
      })

      let btn=document.querySelector('.btn');
      let login=document.querySelector('.login');
      let mask=document.querySelector('.login-bg');
      let closebtn=document.querySelector('#closeBtn');
      let title=document.querySelector('#title');

      btn.addEventListener('click',function(){
        mask.style.display='block';
        login.style.display='block';
      })
      closeBtn.addEventListener('click',function(){
        mask.style.display='none';
        login.style.display='none';
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
    </script>
  </body>
</html>
