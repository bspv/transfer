package com.bazzi.transfer.tests.mapper;

import com.bazzi.transfer.mapper.UserMapper;
import com.bazzi.transfer.model.User;
import com.bazzi.transfer.tests.TestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class MyUserMapperTest extends TestBase {

    @Autowired
    private UserMapper userMapper;

    @Test
    void findByParamTest() {
        User user = userMapper.selectByPrimaryKey(1L);
        print(user);
        assertThat(user.getUserName()).isEqualTo("admin");
    }
}
