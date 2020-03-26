package com.bahadir.demo;


import com.bahadir.demo.Service.GreetingService;
import com.bahadir.demo.model.AccountType;
import com.bahadir.demo.resource.GreetingController;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.security.InvalidParameterException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class HttpRequestTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    GreetingService greetingService;


    @Test
    public void validParameterGreeting() throws Exception {

        mvc.perform( MockMvcRequestBuilders
                .get("/greeting")
                .param("account", AccountType.PERSONAL.toString())
                .param("id", "5")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void invalidParameterGreetingNoAccount() throws Exception {

        mvc.perform( MockMvcRequestBuilders
                .get("/greeting")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
