package com.bahadir.demo.Service;

import com.bahadir.demo.Validator;
import com.bahadir.demo.model.AccountType;
import com.bahadir.demo.model.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bahadir.demo.Constants.*;

@Service
public class GreetingService {

	@Autowired
	Validator validator;


	public String getUser(AccountType accountType, BusinessType businessType, Integer id) {

		validator.validate(accountType, businessType, id);

		if(accountType == AccountType.BUSINESS){
			if(businessType == BusinessType.SMALL){
				return businessSmallGreeting();
			}else{
				return businessBigGreeting();
			}
		}else{
			return personalGreeting(id);
		}
	}


	private String personalGreeting(Integer id){
		return PERSONAL_WELCOME + id;
	}


	private String businessBigGreeting(){
		return BUSINESS_WELCOME;
	}


	private String businessSmallGreeting(){
		throw new UnsupportedOperationException(PATH_NOT_IMPLEMENTED);
	}

}
