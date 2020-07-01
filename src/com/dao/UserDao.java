package com.dao;

import com.pojo.User;

public interface UserDao {

    //if return null, it means no user exist
    public User queryUserByUsername(String username);

    //to save user into db
    public int saveUser(User user);

    //user login. return null if user not exist of password is wrong
    public User queryUserByUsernameAndPassword(String username, String password);
}
