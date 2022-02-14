package com.qipeng.jdbc.util;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/12/31 22:00
 */
public class BaseDao<T> {

    public int insert(T obj) {
        Class<?> clazz = obj.getClass();
        Table table = clazz.getAnnotation(Table.class);
        StringBuilder sb = new StringBuilder();
        String tableName;

        if (table != null) {
            tableName = table.value();
        } else {
            tableName = clazz.getSimpleName();
        }

        Field[] fields = clazz.getDeclaredFields();

        sb.append("INSERT INTO ");
        sb.append(tableName);
        sb.append(" (");

        for (int i = 0; i < fields.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }

            Column column = fields[i].getAnnotation(Column.class);
            String columnName;

            if (column != null) {
                columnName = column.value();
            } else {
                columnName = fields[i].getName();
            }

            sb.append(columnName);
        }

        sb.append(") VALUES(");
        Object[] params = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }

            fields[i].setAccessible(true);

            try {
                params[i] = fields[i].get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            sb.append("?");
        }

        sb.append(")");

        return JdbcUtil.insert(sb.toString(), params);
    }

    public int update(T obj) {
        Class<?> clazz = obj.getClass();
        Table table = clazz.getAnnotation(Table.class);
        StringBuilder sb = new StringBuilder();
        String tableName;

        try {
            if (table != null) {
                tableName = table.value();
            } else {
                tableName = clazz.getSimpleName();
            }

            Field[] fields = clazz.getDeclaredFields();

            sb.append("UPDATE ");
            sb.append(tableName);
            sb.append(" SET ");

            for (int i = 0; i < fields.length; i++) {
                if (i != 0) {
                    sb.append(", ");
                }

                Column column = fields[i].getAnnotation(Column.class);
                String columnName;

                if (column != null) {
                    columnName = column.value();
                } else {
                    columnName = fields[i].getName();
                }

                sb.append(columnName);
                sb.append(" = ");
                sb.append("?");
            }

            Object[] params = new Object[fields.length + 1];

            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);

                params[i] = fields[i].get(obj);
            }

            sb.append(" WHERE id = ?");

            Field id = clazz.getDeclaredField("id");
            id.setAccessible(true);
            params[fields.length] = id.get(obj);

            return JdbcUtil.update(sb.toString(), params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int delete(T obj) {
        return 0;
    }

    public T findOne() {
        return null;
    }

    public List<T> findAll() {
        return null;
    }

    private void splitSQL() {

    }
}
