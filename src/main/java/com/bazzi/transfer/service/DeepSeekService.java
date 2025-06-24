package com.bazzi.transfer.service;

import com.bazzi.transfer.bean.DeepSeekRequest;
import com.bazzi.transfer.bean.DeepSeekResponse;

public interface DeepSeekService {
    DeepSeekResponse getCompletion(DeepSeekRequest request);

}
