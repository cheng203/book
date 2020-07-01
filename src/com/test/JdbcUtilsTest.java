package com.test;

import com.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for(int i = 0; i < 10; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
        }
    }
}
