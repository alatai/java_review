package com.qipeng.jdbc.dao;

import com.qipeng.jdbc.orm.Column;
import com.qipeng.jdbc.orm.JdbcUtil;
import com.qipeng.jdbc.orm.Table;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/12/31 22:00
 */
public class BaseDao<T> {

    public int insert(T obj) {
        try {
            Class<T> clazz = getClazz();
            StringBuilder sb = new StringBuilder();

            String tableName = getTableName(clazz);
            Field[] fields = clazz.getDeclaredFields();

            sb.append("INSERT INTO ");
            sb.append(tableName);
            sb.append(" (");

            for (int i = 0; i < fields.length; i++) {
                splitSQL(sb, fields, i);
            }

            sb.append(") VALUES(");
            Object[] params = new Object[fields.length];

            for (int i = 0; i < fields.length; i++) {
                if (i != 0) {
                    sb.append(", ");
                }

                fields[i].setAccessible(true);
                params[i] = fields[i].get(obj);

                sb.append("?");
            }

            sb.append(")");

            return JdbcUtil.insert(sb.toString(), params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int update(T obj) {
        try {
            Class<T> clazz = getClazz();
            StringBuilder sb = new StringBuilder();

            String tableName = getTableName(clazz);
            Field[] fields = clazz.getDeclaredFields();

            sb.append("UPDATE ");
            sb.append(tableName);
            sb.append(" SET ");

            for (int i = 0; i < fields.length; i++) {
                splitSQL(sb, fields, i);
                sb.append(" = ");
                sb.append("?");
            }

            Object[] params = new Object[fields.length + 1];

            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);

                params[i] = fields[i].get(obj);
            }

            sb.append(" WHERE id = ? ");

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
        try {
            Class<T> clazz = getClazz();
            StringBuilder sb = new StringBuilder();
            String tableName = getTableName(clazz);

            sb.append("DELETE FROM ");
            sb.append(tableName);
            sb.append(" WHERE id = ? ");

            Field id = clazz.getDeclaredField("id");
            id.setAccessible(true);

            Object[] params = new Object[1];
            params[0] = id.get(obj);

            return JdbcUtil.delete(sb.toString(), params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int deleteById(int id) {
        try {
            Class<T> clazz = getClazz();
            Table table = clazz.getAnnotation(Table.class);

            StringBuilder sb = new StringBuilder();
            String tableName = table != null ? table.value() : clazz.getSimpleName();

            sb.append("DELETE FROM ");
            sb.append(tableName);
            sb.append(" WHERE id = ? ");

            return JdbcUtil.delete(sb.toString(), id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public T findById(int id) {
        try {
            Class<T> clazz = getClazz();
            StringBuilder sb = new StringBuilder();
            doFind(clazz, sb);
            sb.append(" WHERE id = ? ");

            return JdbcUtil.findOne(sb.toString(), clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<T> findAll() {
        try {
            Class<T> clazz = getClazz();
            StringBuilder sb = new StringBuilder();
            doFind(clazz, sb);

            return JdbcUtil.findAll(sb.toString(), clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Class<T> getClazz() throws ClassNotFoundException {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;

        Type genericType = parameterizedType.getActualTypeArguments()[0];
        String className = genericType.getTypeName();

        //noinspection unchecked
        return (Class<T>) Class.forName(className);
    }

    private String getTableName(Class<T> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        return table != null ? table.value() : clazz.getSimpleName();
    }

    private void doFind(Class<T> clazz, StringBuilder sb) {
        String tableName = getTableName(clazz);

        sb.append("SELECT * FROM ");
        sb.append(tableName);
    }

    private void splitSQL(StringBuilder sb, Field[] fields, int i) {
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
}
