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
  <link rel="stylesheet" href="./Manager_index_style.css">
</head>
<body>
<div class="container">
  <header class="header">
    <span>管理界面</span>
    <h1>用户信息管理界面</h1>
    <img src="./images/左箭头.png" alt="" class="arrow">
  </header>
  <div class="box">
    <img src="./images/导航栏2.png" alt="" class="btn">
  </div>
  <ul class="menu">
    <li><a href="#" class="tab1">管理员信息</a></li>
    <li><a href="#" class="tab2">查看所有用户</a></li>
    <li><a href="#" class="tab3">查看所有图书</a></li>
    <li><a href="#" class="tab4">增加图书界面</a></li>
    <li><a href="#" class="tab5">修改图书界面</a></li>
    <li><a href="#" class="tab6">查看图书借阅情况</a></li>
    <li><a href="#" class="tab7">Download</a></li>
  </ul>
  <%
    List<Book> bookList = (List<Book>) session.getAttribute("bookList");
    List<User> userList = (List<User>) session.getAttribute("userList");
    List<Borrow> borrowList = (List<Borrow>) session.getAttribute("borrowList");
  %>
  <div class="main">
    <div class="content" id="box1">
      <p style="font-size: 50px;color: white">你好，管理员${admin}</p>
    </div>
    <div class="content" id="box2">
      <table class="table_container" id="table2">
        <tr>
          <td>用户名</td>
          <td>密码</td>
          <td>身份</td>
          <td>借阅图书数量</td>
          <td>操作</td>
        </tr>
        <%for (User user:userList) {%>
        <tr>
          <td><%=user.getUserId()%></td>
          <td><%=user.getPassword()%></td>
          <td><%=user.getIdentity()%></td>
          <td><%=user.getBookNum()%></td>
          <td class="btn_td">
            <a class="delete_btn1" href="userDelete?userId=<%=user.getUserId()%>">删除</a>
          </td>
        </tr>
        <%}%>
      </table>
    </div>
    <div class="content" id="box3">
      <table class="table_container" id="table3">
        <tr>
          <td>bookId</td>
          <td>bookName</td>
          <td>author</td>
          <td>price</td>
          <td>remarks</td>
          <td>isBorrowed</td>
          <td>操作</td>
        </tr>
        <%for (Book book:bookList) {%>
        <tr>
          <td><%=book.getBookId()%></td>
          <td><%=book.getBookName()%></td>
          <td><%=book.getAuthor()%></td>
          <td><%=book.getPrice()%></td>
          <td><%=book.getRemarks()%></td>
          <td><%=book.getIsBorrowed()%></td>
          <td class="btn_td2"><a class="update_btn" href="update1?bookId=<%=book.getBookId()%>">修改图书信息</a>
              <a class="delete_btn" href="delete?bookId=<%=book.getBookId()%>">删除</a>
          </td>
        </tr>
        <%}%>
      </table>
    </div>
    <div class="content" id="box4">
      <h1>增加图书</h1>
      <form method="post" action="add" class="form1">
        <table class="table_add">
          <tr>
          <td>图书id：</td>
          <td><input type="text" name="bookId"></td>
          </tr><tr>
          <td>图书名：</td>
          <td><input type="text" name="bookName"></td>
          </tr><tr>
          <td>作者：</td>
          <td><input type="text" name="author"></td>
          </tr><tr>
          <td>价格：</td>
          <td><input type="text" name="price"></td>
          </tr><tr>
          <td>备注：</td>
          <td><input type="text" name="remarks"></td>
          </tr>
          <tr>
            <td><input type="submit" value="添加" class="add_btn"></td>
          </tr>
        </table>
      </form>
    </div>
    <div class="content" id="box5">
      <h1>修改图书</h1>
      <form method="post" action="update2" class="form2">
        <table class="table_update">
        <tr>
          <td>图书id：</td>
          <td><input type="text" name="bookId" value="${bookId}"></td>
        </tr>
          <tr>
          <td>图书名：</td>
          <td><input type="text" name="bookName" value="${bookName}"></td>
          </tr>
          <tr>
          <td>作者：</td>
          <td><input type="text" name="author" value="${author}"></td>
          </tr>
          <tr>
          <td>价格：</td>
          <td><input type="text" name="price" value="${price}"></td>
          </tr>
          <tr>
          <td>备注：</td>
          <td><input type="text" name="remarks" value="${remarks}"></td>
          </tr>
        <tr>
          <td><input type="submit" value="修改" class="change_btn"></td>
        </tr>
        </table>
      </form>
      <input type="hidden" name="getPage" value="${swf}" class="getPage">
    </div>
    <div class="content" id="box6">
      <table class="table_container" id="">
        <tr>
          <td>用户名</td>
          <td>图书ID</td>
          <td>图书名称</td>
          <td>作者</td>
          <td>借书时间</td>
          <td>还书时间</td>
        </tr>
        <%for (Borrow borrow:borrowList) {%>
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
<script>
  let btn=document.querySelector('.btn');
  let as=document.querySelectorAll('a');
  let i=false;
  btn.addEventListener('click',function (){
    i=!i;
    if(i==true){
      for(let i=0;i<as.length;i++){
        as[i].style.display='block';
      }
    }else{
      for(let i=0;i<as.length;i++){
        as[i].style.display='none';
      }
    }
  })

  let contents=document.querySelectorAll('.content');

  for(let i=0;i<as.length;i++){
    as[i].addEventListener('click',function (){
      for(let j=0;j<contents.length;j++){
        contents[j].style.display='none';
      }
      contents[i].style.display='block';
    })
  }

  let arrow=document.querySelector('.arrow');
  arrow.addEventListener('click',function (){
    window.location.href='login-index.jsp';
  })


  let j;
  let getPage=document.querySelector('.getPage');
  j=getPage.value;
  for(let m=0;m<contents.length;m++){
      contents[m].style.display='none';
  }
  contents[j].style.display='block';

</script>
</body>
</html>
