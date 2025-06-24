package com.bazzi.transfer.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeepSeekRequest {
    private String model;
    private List<Message> messages;
    private boolean stream; // 是否使用流式响应
}