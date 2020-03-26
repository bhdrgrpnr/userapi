package com.bahadir.demo.config;


import com.bahadir.demo.model.AccountType;
import org.springframework.core.convert.converter.Converter;

public class AccountTypeConverter implements Converter<String, AccountType> {
    @Override
    public AccountType convert(String source) {
        try {
            return AccountType.valueOf(source.toUpperCase());
        } catch(Exception e) {
            return null;
        }
    }
}
