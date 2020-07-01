package com.service;

import com.pojo.User;
import sun.security.provider.certpath.PKIXTimestampParameters;

public interface UserService {
    public void register(User user);

    public User login(User user);

    public boolean existsUsername(String username);
}
