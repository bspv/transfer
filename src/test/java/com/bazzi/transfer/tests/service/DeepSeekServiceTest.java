package com.bazzi.transfer.tests.service;

import com.bazzi.transfer.bean.DeepSeekRequest;
import com.bazzi.transfer.bean.DeepSeekResponse;
import com.bazzi.transfer.bean.Message;
import com.bazzi.transfer.service.impl.DeepSeekServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.Collections;

@Slf4j
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@ActiveProfiles("dev")  // 加载完整上下文并使用dev配置
class DeepSeekServiceTest {

    @Resource
    private DeepSeekServiceImpl deepSeekService;

    @Test
    void testDeepseekChatApi() {
        DeepSeekRequest request = new DeepSeekRequest(
                "deepseek-chat",
                Collections.singletonList(new Message("user", "请比较一下Qwen3和DeepSeek")),
                false
        );

        DeepSeekResponse response = deepSeekService.getCompletion(request);
        log.info("API响应: {}", response);
    }
}