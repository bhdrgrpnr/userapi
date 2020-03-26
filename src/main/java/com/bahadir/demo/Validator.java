package com.bahadir.demo;

import com.bahadir.demo.model.AccountType;
import com.bahadir.demo.model.BusinessType;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

import static com.bahadir.demo.Constants.*;

@Component
public class Validator {

    public void validate(AccountType accountType, BusinessType businessType, Integer id){

        if(accountType == null){
            throw new InvalidParameterException(ACCOUNT_TYPE_SHOULD_BE_PROVIDED);
        }

        if(accountType == AccountType.PERSONAL && id == null){
            throw new InvalidParameterException(ID_SHOULD_BE_PROVIDED);
        }

        if(accountType == AccountType.BUSINESS && businessType == null){
            throw new InvalidParameterException(BUSINESS_TYPE_SHOULD_BE_PROVIDED);
        }
    }

}
