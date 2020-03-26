package com.bahadir.demo;

import com.bahadir.demo.Service.GreetingService;
import com.bahadir.demo.model.AccountType;
import com.bahadir.demo.model.BusinessType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.InvalidParameterException;

import static com.bahadir.demo.Constants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingTests {

	@Autowired
	GreetingService greetingService;

	@Test
	public void AccountTypeEmptyTest() {

		Exception exception = assertThrows(InvalidParameterException.class, () -> {
			greetingService.getUser(null, null, null);
		});

		Assert.assertTrue(exception.getMessage().equals(ACCOUNT_TYPE_SHOULD_BE_PROVIDED));
	}

	@Test
	public void PersonalAccountTypeTest() {
		int id = 5;
		String response = greetingService.getUser(AccountType.PERSONAL, null, id);
		Assert.assertTrue(response.equals(PERSONAL_WELCOME + id));
	}

	@Test
	public void BusinessAccountTypeBigTest() {
		String response = greetingService.getUser(AccountType.BUSINESS, BusinessType.BIG, null);
		Assert.assertTrue(response.equals(BUSINESS_WELCOME));
	}

	@Test
	public void BusinessAccountTypeSmallTest() {

		Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
			greetingService.getUser(AccountType.BUSINESS, BusinessType.SMALL, null);
		});

		Assert.assertTrue(exception.getMessage().equals(PATH_NOT_IMPLEMENTED));
	}

	@Test
	public void PersonalAccountTypeInvalidIdTest() {
		Exception exception = assertThrows(InvalidParameterException.class, () -> {
			greetingService.getUser(AccountType.PERSONAL, null, null);
		});

		Assert.assertTrue(exception.getMessage().equals(ID_SHOULD_BE_PROVIDED));
	}


}

