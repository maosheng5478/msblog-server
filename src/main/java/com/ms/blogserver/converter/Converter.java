package com.ms.blogserver.converter;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toDataNoNull(T t, @MappingTarget R r);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromDataNoNull(R r, @MappingTarget T t);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toDataListNoNull(List<T> tList,@MappingTarget List<R> rList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromDataListNoNull(List<R> rList,@MappingTarget List<T> tList);
}
