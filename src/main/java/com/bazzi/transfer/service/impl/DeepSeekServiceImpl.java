package com.bazzi.transfer.service.impl;

import com.bazzi.transfer.bean.DeepSeekRequest;
import com.bazzi.transfer.bean.DeepSeekResponse;
import com.bazzi.transfer.service.DeepSeekService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeepSeekServiceImpl implements DeepSeekService {
    private final WebClient webClient;

    @Override
    public DeepSeekResponse getCompletion(DeepSeekRequest request) {
        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(DeepSeekResponse.class).block();
    }
}
