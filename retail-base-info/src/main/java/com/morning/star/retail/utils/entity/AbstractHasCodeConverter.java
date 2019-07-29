package com.morning.star.retail.utils.entity;

import javax.persistence.AttributeConverter;

public abstract class AbstractHasCodeConverter<T extends HasCode> implements AttributeConverter<T, Integer> {
    
    @Override
    public Integer convertToDatabaseColumn(T status) {
        return status == null ? null : status.getCode();
    }
    
    @Override
    public T convertToEntityAttribute(Integer value) {
        if(value == null) {
            return null;
        }
        T result = from(value);
        if(result == null) {
            throw new RuntimeException("Unknown database value: " + value);
        }
        return result;
    }
    
    public abstract T from(Integer code);

}
