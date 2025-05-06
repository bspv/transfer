package com.bazzi.transfer.mapper;

import com.bazzi.core.generic.BaseMapper;
import com.bazzi.transfer.model.User;

public interface UserMapper extends BaseMapper<User> {
    User findByUsername(String username);
}