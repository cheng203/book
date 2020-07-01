package com.dao.impl;

import com.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    //used to run insert/update/delete
    public int update(String sql, Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            queryRunner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    //used to search one javabean sql language
    public <T> T queryForOne(Class<T> type, String sql, Object ...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object ...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }


    // used to return one row, one col sql, like COUNT(), MAX()
    public Object queryForSingleValue(String sql, Object ...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            queryRunner.query(conn, sql, new ScalarHandler());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
