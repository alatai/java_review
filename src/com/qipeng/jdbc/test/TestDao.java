package com.qipeng.jdbc.test;

import com.qipeng.jdbc.dao.UserDao;
import com.qipeng.jdbc.entity.User;

import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2022/01/01 0:24
 */
public class TestDao {

    public static void main(String[] args) {
        User user = new User();
        user.setName("test");
        user.setAge(27);

        UserDao userDao = new UserDao();

        List<User> users = userDao.findAll();

        for (User u : users) {
            System.out.println(u);
        }

        System.out.println("=========");

        user = userDao.findById(6);
        System.out.println(user);

        user.setName("update");
        user.setAge(11);
        user.setId(6);
        userDao.update(user);

        user = userDao.findById(6);
        System.out.println(user);
    }
}
