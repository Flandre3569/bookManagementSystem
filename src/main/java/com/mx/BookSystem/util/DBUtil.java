package com.mx.BookSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
    private String dbUrl="jdbc:mysql://localhost:3306/librarymanagement?useUnicode=true&characterEncoding=UTF-8"; // 数据库连接地址
    private String dbUserName="root"; // 用户名
    private String dbPassword="123456"; // 密码
    private String jdbcName="com.mysql.cj.jdbc.Driver"; // 驱动名称

    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return connection;
    }

    public void close(ResultSet rs, Statement st, Connection conn) throws Exception {
        if (rs != null){ rs.close();}
        if (st != null) {st.close();}
        if (conn != null){ conn.close();}
    }
}
