package com.mx.BookSystem.dao;

import java.util.List;

import com.mx.BookSystem.bean.Borrow;
import com.mx.BookSystem.bean.User;

public interface BorrowDao {
	//查询所有借书业务
    public List<Borrow> queryAll() throws Exception;
    //通过id查询用户借书业务
    public List<Borrow> queryById(String userId)throws Exception;
    //增加一个业务
    public void add(Borrow b)throws Exception;
    //根据图书id删除一个业务
    public void delete(String bookId )throws Exception;
    //延长借书时间
    public void delay(int num,String id)throws Exception;
}
