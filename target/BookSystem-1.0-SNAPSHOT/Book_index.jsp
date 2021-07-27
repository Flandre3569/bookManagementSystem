<%@ page import="com.mx.BookSystem.bean.Book" %>
<%@ page import="java.util.List" %>
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
    <link rel="stylesheet" href="./book_index_style.css">
  </head>
  <body>
  <div class="container">
    <div class="header">
    <h1>Fine collection of books</h1>
      <img src="./images/箭头.png" alt="" class="arrow">
    </div>

    <div class="main">
      <ul class="tabs">
        <li>
          <input type="radio" checked name="tabs" id="tab1">
          <label for="tab1">书架</label>
          <div id="tab-content1" class="tab-content">
            <%
              List<Book> bookList = (List<Book>) request.getAttribute("bookList");
              if(!bookList.isEmpty()){
            %>
            <table class="table_container">
              <tr>
                <td>bookId</td>
                <td>bookName</td>
                <td>author</td>
                <td>price</td>
                <td>remarks</td>
                <td>isBorrowed</td>
                <td>borrow</td>
              </tr>
              <%for (Book book:bookList) {%>
              <tr>
                <td><%=book.getBookId()%></td>
                <td><%=book.getBookName()%></td>
                <td><%=book.getAuthor()%></td>
                <td><%=book.getPrice()%></td>
                <td><%=book.getRemarks()%></td>
                <td><%=book.getIsBorrowed()%></td>
                <td class="btn_td"><a class="borrow_btn" href="borrow?bookId=<%=book.getBookId()%>">借阅</a></td>
              </tr>
              <%}
              }%>
            </table>
          </div>
        </li>
        <li>
          <input type="radio" name="tabs" id="tab2">
          <label for="tab2">我的图书</label>
          <div id="tab-content2" class="tab-content">
            <%
              List<Borrow> borrowList = (List<Borrow>) request.getAttribute("borrowList");
              if(!borrowList.isEmpty()){
            %>
            <table class="table_container">
              <tr>
                <td>userId</td>
                <td>bookId</td>
                <td>bookName</td>
                <td>author</td>
                <td>borrowTime</td>
                <td>returnTime</td>
              </tr>
              <%for (Borrow borrow:borrowList) {%>
              <tr>
                <td><%=borrow.getUserId()%></td>
                <td><%=borrow.getBookId()%></td>
                <td><%=borrow.getBookName()%></td>
                <td><%=borrow.getAuthor()%></td>
                <td><%=borrow.getBorrowTime()%></td>
                <td><%=borrow.getReturnTime()%></td>
                <td class="btn_td"><a class="borrow_btn" href="return?bookId=<%=borrow.getBookId()%>">还书</a></td>
                <td class="btn_td"><a class="borrow_btn" href="delay?bookId=<%=borrow.getBookId()%>">延时</a></td>
              </tr>
              <%}
              }%>
            </table>
          </div>
        </li>
        <li>
          <input type="radio" name="tabs" id="tab3">
          <label for="tab3">图书搜索</label>
          <div id="tab-content3" class="tab-content">
            <%
              Book book= (Book) request.getAttribute("book");
              if(book!=null){
            %>
            <table class="table_container">
              <tr>
                <td>bookId</td>
                <td>bookName</td>
                <td>author</td>
                <td>price</td>
                <td>remarks</td>
                <td>isBorrowed</td>
                <td>borrow</td>
              </tr>
              <tr>
                <td><%=book.getBookId()%></td>
                <td><%=book.getBookName()%></td>
                <td><%=book.getAuthor()%></td>
                <td><%=book.getPrice()%></td>
                <td><%=book.getRemarks()%></td>
                <td><%=book.getIsBorrowed()%></td>
                <% int pp=0;
                  for (Borrow bo:borrowList) {
                    if(book.getBookName().equals(bo.getBookName())){pp=1;}}
                  if(pp==1){
                %>
                <td class="btn_td"><a class="borrow_btn" href="return?bookId=<%=book.getBookId()%>">还书</a></td>
                <%}else {%>
                <td class="btn_td"><a class="borrow_btn" href="borrow?bookId=<%=book.getBookId()%>">借书</a></td>
                <%}}
                %></tr>
              <%if(book==null){%>
              <tr>暂无搜索书籍</tr>
              <%}%>
            </table>
          </div>
        </li>
      </ul>
      <input type="hidden" class="getPage" id="getPage" value="${swf}">
      <input type="hidden" class="getType" id="getType" value="${type}">
    </div>
  </div>


  <script>
    let tabs=document.querySelector('.tabs');
    let lis=document.querySelectorAll('li');
    let tab_contents=document.querySelectorAll('.tab-content');

    for(let i=0;i<lis.length;i++){
        lis[i].addEventListener('click',function (){
          for(let j=0;j<lis.length;j++){
            lis[j].children[2].style.display='none';
          }
            lis[i].children[2].style.display='block';
        })
    }

    let arrow=document.querySelector('.arrow');
    arrow.addEventListener('click',function (){
        window.location.href='./index.jsp';
    })

    let j;
    let getPage=document.querySelector('.getPage');
    j=getPage.value;

    for(let m=0;m<tab_contents.length;m++){
      tab_contents[m].style.display='none';
    }
    tab_contents[j].style.display='block';

    let getType=document.querySelector('.getType');
    let x=getType.value;
    console.log(x);


  </script>
  </body>
</html>
