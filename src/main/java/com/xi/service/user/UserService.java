package com.xi.service.user;

import com.xi.pojo.User;

public interface UserService {
    public User login(String userCode,String password);
}
