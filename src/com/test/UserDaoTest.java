package com.test;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDaoImpl = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        System.out.println(userDaoImpl.queryUserByUsername("admin"));
    }

    @Test
    public void saveUser() {
        User user = new User("william", "happy95@", "william@gmail.com");
        userDaoImpl.saveUser(user);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDaoImpl.queryUserByUsernameAndPassword("william", "Happy95@"));
    }
}