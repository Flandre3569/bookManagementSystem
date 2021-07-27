package com.mx.BookSystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mx.BookSystem.bean.Borrow;
import com.mx.BookSystem.bean.User;
import com.mx.BookSystem.util.DBUtil;

public class BorrowDaoImpl implements BorrowDao {
	private DBUtil util = new DBUtil();
	@Override
	public List<Borrow> queryAll() throws Exception {
		List<Borrow> borrowList = new ArrayList<Borrow>();
        Connection con = util.getCon();
        String sql = "select * from borrow;";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            String userId = rs.getString("userId");
            String bookId = rs.getString("bookId");
            String bookName = rs.getString("bookName");
            String author = rs.getString("author");
            Date borrowTime=rs.getDate("borrowTime");
            Date returnTime=rs.getDate("returnTime");
            Borrow b = new Borrow(userId,bookId,bookName,author,borrowTime,returnTime);
            borrowList.add(b);
        }
        util.close(rs, pst, con);
        return borrowList;
	}

	@Override
	public List<Borrow> queryById(String userId) throws Exception {
		List<Borrow> borrowList = new ArrayList<Borrow>();
		Connection con = util.getCon();
        String sql = "select * from borrow where userId = ?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,userId);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            if(userId.equals(rs.getString("userId"))){
            	String Id = rs.getString("userId");
                String bookId = rs.getString("bookId");
                String bookName = rs.getString("bookName");
                String author = rs.getString("author");
                Date borrowTime=rs.getDate("borrowTime");
                Date returnTime=rs.getDate("returnTime");
                Borrow b = new Borrow(Id,bookId,bookName,author,borrowTime,returnTime);
                borrowList.add(b);
            }
        }
        util.close(rs, pst, con);
		return borrowList;
	}

	@Override
	public void add(Borrow b) throws Exception {
		Connection con=util.getCon();
		String sql="insert into borrow(userId,bookId,bookName,author,borrowTime,returnTime) values(?,?,?,?,?,?);";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, b.getUserId());
		ps.setString(2, b.getBookId());
		ps.setString(3, b.getBookName());
		ps.setString(4, b.getAuthor());
		ps.setDate(5, b.getBorrowTime());
		ps.setDate(6, b.getReturnTime());
		ps.executeUpdate();
		util.close(null, ps, con);
	}

	@Override
	public void delay(int num,String id) throws Exception {
		Connection conn=util.getCon();
		String sql1="update borrow set returnTime=? where bookId="+id+";";
		String sql2="select * from borrow where bookId="+id+";";
		PreparedStatement ps1=conn.prepareStatement(sql1);
		PreparedStatement ps2=conn.prepareStatement(sql2);
		ResultSet rs2=ps2.executeQuery();
		Date d=null;
		while(rs2.next()) {
			Date d2=rs2.getDate("returnTime");
			Calendar ca=Calendar.getInstance();
			ca.setTime(d2);
			ca.add(Calendar.DAY_OF_YEAR,num);
			Date d1=new Date(ca.getTime().getTime());
			d=d1;
		}
		ps1.setDate(1, d);
		int n=ps1.executeUpdate();
		try{
			int p=ps1.executeUpdate();
			if(p==1){
				System.out.println("数据修改操作成功！");
			}
			else{
				System.out.println("数据修改操作失败！");
			}
		}catch(Exception e){
			System.out.println("修改过程出现异常错误！");
			System.out.println(e.getMessage());}

		util.close(rs2, ps2, conn);
		util.close(null, ps1, null);
	}

	@Override
	public void delete(String bookId) throws Exception {
		Connection conn=util.getCon();
		String sql="delete from borrow where bookId="+bookId+";";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.executeUpdate();
		util.close(null, ps, conn);

	}

}
