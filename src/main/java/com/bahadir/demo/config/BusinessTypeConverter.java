package com.bahadir.demo.config;


import com.bahadir.demo.model.BusinessType;
import org.springframework.core.convert.converter.Converter;

public class BusinessTypeConverter implements Converter<String, BusinessType> {
    @Override
    public BusinessType convert(String source) {
        try {
            return BusinessType.valueOf(source.toUpperCase());
        } catch(Exception e) {
            return null;
        }
    }
}
