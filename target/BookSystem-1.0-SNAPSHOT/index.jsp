<%--
  Created by IntelliJ IDEA.
  User: Fan
  Date: 2021/6/22
  Time: 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="./MimicryButton.css" />
  <link rel="stylesheet" href="./search.css">
</head>
<body>
<div class="index_body">
  <form class="box" action="SearchServlet" method="get" id="box_search">
    <input type="text" name="searchName" placeholder="search">
  </form>

  <div class="box2">
    <img src="./images/主页2.png" alt="" class="btn">
  </div>

  <div class="container">
    <div class="box" id="select-book">
      <div class="img"><img src="./images/book1.png" alt="点击进入图书馆选择页面" /></div>
      <p>图书选读</p>
    </div>
    <div class="box" id="select-user">
      <div class="img"><img src="./images/user1.png" alt="点击进入个人主页" /></div>
      <p>个人主页</p>
    </div>
  </div>
</div>

<script>
  let select_book=document.querySelector('#select-book');
  let select_user=document.querySelector('#select-user');
  select_book.addEventListener('click',function (){
    window.location.href='./book';
  })
  select_user.addEventListener('click',function(){
    window.location.href='./user';
  })

  let back=document.querySelector('.box2');
  back.addEventListener('click',function (){
      window.location.href='./login-index.jsp';
  })

</script>
</body>
</html>
