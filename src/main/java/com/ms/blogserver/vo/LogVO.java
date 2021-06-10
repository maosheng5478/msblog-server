package com.ms.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/10
 */
@Data
@AllArgsConstructor
public class LogVO {
    private String fileName;
    private String time;
    private String context;

    public LogVO() {
    }
}
