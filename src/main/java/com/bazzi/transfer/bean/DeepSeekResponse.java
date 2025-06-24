package com.bazzi.transfer.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeepSeekResponse {
    private String id;
    private String object;
    private long created;
    private List<Choice> choices;
}