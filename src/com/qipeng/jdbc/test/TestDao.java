package com.qipeng.jdbc.test;

import com.qipeng.jdbc.dao.UserDao;
import com.qipeng.jdbc.model.User;
import com.qipeng.jdbc.util.JdbcUtil;

import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2022/01/01 0:24
 */
public class TestDao {

    public static void main(String[] args) {
        User user = new User();
        user.setId(4);
        user.setName("tom");
        user.setAge(28);

        UserDao<User> userDao = new UserDao<>();
        // userDao.insert(user);

        userDao.update(user);

        String sql = "SELECT * FROM User";
        List<User> users = JdbcUtil.findAll(sql, User.class);

        for (User u : users) {
            System.out.println(u);
        }
    }
}
