package com.test;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void register() {
        userService.register(new User("fiona", "12342", "fiona@gmail.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User("fiona", "12342", null)));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("fiona"));
    }
}