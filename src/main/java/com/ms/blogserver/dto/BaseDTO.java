package com.ms.blogserver.dto;

import com.ms.blogserver.constant.contexts.DigitalContexts;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@ToString
public class BaseDTO implements Serializable {

    private Integer page = DigitalContexts.ONE;
    private Integer size = DigitalContexts.FIVE;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page > 0) {
            this.page = page;
        }
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        if (size > 0) {
            this.size = size;
        }
    }
}
