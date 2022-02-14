package com.qipeng.jdbc.test;

import java.sql.*;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/12/17 11:02
 */
public class TestJdbc {

    private static final String URL = "jdbc:mysql://localhost:3306/base?characterEncoding=UTF-8&serverTimezone=GMT%2B8&useServerPrepStms=true&cachePrepStms=true";
    private static final String USER = "root";
    private static final String PASSWORD = "Qp/19940413";

    static {
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        query();
        // query2();
    }

    /**
     * 静态SQL语句
     */
    private static void query() {
        // 获取连接
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // 创建语言对象
            // 用于执行静态SQL的语句对象用于把SQL语句发送到数据库中去执行，并返回执行后的结果
            try (Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM emp WHERE empno";

                // 执行SQL
                // 执行DQL操作后会产生一个结果集，而ResultSet就是对结果集做的封装
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    for (int i = 0; i < metaData.getColumnCount(); i++) {
                        // String columnName = metaData.getColumnName(i + 1);
                        String columnName = metaData.getColumnLabel(i + 1);
                        System.out.println("columnName = " + columnName);
                    }
                    while (resultSet.next()) {
                        int empno = resultSet.getInt("empno");
                        String name = resultSet.getString("ename");
                        System.out.println(empno + " - " + name);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用预编译语句
     */
    private static void query2() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM emp WHERE empno = ?")) {
                ps.setInt(1, 7369);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString("ename"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
