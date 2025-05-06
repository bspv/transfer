package com.bazzi.transfer.service;

import com.bazzi.transfer.model.User;

public interface UserService {
    User login(String username, String password);
}
