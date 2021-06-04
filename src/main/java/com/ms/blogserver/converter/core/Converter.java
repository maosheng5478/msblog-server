package com.ms.blogserver.converter.core;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/31
 */
public interface Converter<T extends Serializable,R> {

    R toData(T t);

    T fromData(R r);

    List<R> toDataList(List<T> tList);

    List<T> fromDataList(List<R> rList);
}
