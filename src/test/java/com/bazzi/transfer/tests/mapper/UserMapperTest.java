package com.bazzi.transfer.tests.mapper;

import com.bazzi.transfer.config.DefinitionProperties;
import com.bazzi.transfer.mapper.UserMapper;
import com.bazzi.transfer.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@Transactional
@ActiveProfiles("dev")  // 指定使用dev配置
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DefinitionProperties definitionProperties;

    @Test
    void testInsertAndSelect() {
        // 测试数据准备
        User newUser = new User();
        newUser.setUserName("dev_test_user");
        newUser.setPassword("encrypted_password");

        // 执行插入
        int insertResult = userMapper.insert(newUser);
        assertThat(insertResult).isEqualTo(1);

        // 执行查询
        User paramU = new User();
        paramU.setUserName(newUser.getUserName());
        User foundUser = userMapper.selectOne(paramU);
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getPassword()).isEqualTo("encrypted_password");
        log.info(definitionProperties.getCachePrefix());
    }
}