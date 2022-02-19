package com.qipeng.jdbc.test;

import com.qipeng.jdbc.entity.Salgrade;
import com.qipeng.jdbc.orm.JdbcUtil;

import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/12/31 17:42
 */
public class TestJdbcUtil {

    public static void main(String[] args) throws Exception {
        String sql = "SELECT * FROM salgrade";
        List<Salgrade> salgrades = JdbcUtil.findAll(sql, Salgrade.class);

        for (Salgrade salgrade : salgrades) {
            System.out.println(salgrade);
        }

        System.out.println("==========");

        sql = "SELECT * FROM salgrade WHERE grade = ?";
        Salgrade salgrade = JdbcUtil.findOne(sql, Salgrade.class, 2);
        System.out.println(salgrade);

        sql = "INSERT INTO salgrade (grade, losal, hisal) VALUES (?, ?, ?)";
        // JdbcUtil.insert(sql, 6, 20000, 30000);

        sql = "UPDATE salgrade SET hisal = ? WHERE grade = ?";
        JdbcUtil.update(sql, 50000, 6);
    }
}
