package com.qipeng.jdbc.util;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/12/31 13:44
 */
public class JdbcUtil {

    private static String url;
    private static String user;
    private static String password;

    /*
     * 加载注册驱动
     */
    static {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            String driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 关闭连接
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();

                if (statement != null) {
                    statement.close();

                    if (connection != null) {
                        connection.close();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行DML操作（增删改）
     *
     * @return 受影响行数
     */
    private static int executeDML(String sql, Object... params) {
        int result = 0;

        try (Connection conn = getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                if (params != null) {
                    for (int i = 0; i < params.length; i++) {
                        ps.setObject(i + 1, params[i]);
                    }
                }

                result = ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int insert(String sql, Object... params) {
        return executeDML(sql, params);
    }

    public static int update(String sql, Object... params) {
        return executeDML(sql, params);
    }

    public static int delete(String sql, Object... params) {
        return executeDML(sql, params);
    }

    /**
     * 查询结果封装为Java对象
     */
    private static <T> T getObject(ResultSet rs, Class<T> clazz) {
        T object = null;

        try {
            object = clazz.getDeclaredConstructor().newInstance();
            ResultSetMetaData metaData = rs.getMetaData();
            Field[] fields = clazz.getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                String columnName = metaData.getColumnLabel(i + 1);
                PropertyDescriptor propertyDescriptor = null;

                Column column = fields[i].getAnnotation(Column.class);

                if (column != null) {
                    String value = column.value();

                    if (columnName.equals(value)) {
                        propertyDescriptor = new PropertyDescriptor(fields[i].getName(), clazz);
                    }
                } else {
                    propertyDescriptor = new PropertyDescriptor(columnName, clazz);
                }

                assert propertyDescriptor != null;
                Method method = propertyDescriptor.getWriteMethod();
                method.invoke(object, rs.getObject(columnName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    /**
     * 执行DQL操作（查询）
     */
    private static <T> List<T> executeDQL(String sql, Class<T> clazz, Object... params) {
        List<T> list = new ArrayList<>();

        try (Connection conn = getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                if (params != null) {
                    for (int i = 0; i < params.length; i++) {
                        ps.setObject(i + 1, params[i]);
                    }
                }

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        T object = getObject(rs, clazz);
                        list.add(object);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static <T> List<T> findAll(String sql, Class<T> clazz, Object... params) {
        return executeDQL(sql, clazz, params);
    }

    public static <T> T findOne(String sql, Class<T> clazz, Object... params) {
        return executeDQL(sql, clazz, params).get(0);
    }
}
