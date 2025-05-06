package com.bazzi.transfer.tests.service;

import com.bazzi.core.ex.BusinessException;
import com.bazzi.core.util.DigestUtil;
import com.bazzi.transfer.mapper.UserMapper;
import com.bazzi.transfer.model.User;
import com.bazzi.transfer.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@ActiveProfiles("dev")  // 加载完整上下文并使用dev配置
class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testLoginWithRealPasswordEncoder() {
        // 准备测试数据
        String rawPassword = "dev_password_123";
        User mockUser = new User();
        mockUser.setUserName("dev_user");
        mockUser.setPassword(DigestUtil.toMd5Upper(rawPassword));

        when(userMapper.findByUsername("dev_user")).thenReturn(mockUser);

        // 执行登录
        User result = userService.login("dev_user", rawPassword);

        // 验证结果
        assertThat(result).isEqualTo(mockUser);
    }

    @Test
    void testLoginFailure() {
        User paramUser = new User();
        paramUser.setUserName("unknown");
        when(userMapper.selectOne(paramUser)).thenReturn(null);

        assertThatThrownBy(() -> userService.login("unknown", "any"))
            .isInstanceOf(BusinessException.class)
            .hasMessageContaining("用户不存在");
    }
}