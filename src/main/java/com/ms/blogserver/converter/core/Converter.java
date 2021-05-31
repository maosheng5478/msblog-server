package com.ms.blogserver.converter.core;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/31
 */
public interface Converter<T extends Serializable,R> {

    R toData(T t);

    T fromData(R r);
}
