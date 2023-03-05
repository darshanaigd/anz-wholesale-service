package com.anz.wholesale.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAccountsByCustomerId_success() throws Exception {
        mockMvc.perform(get("/accounts/{customerId}", 1001L)
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"accountNumber\":1234596789,\"accountName\":\"SGSavings726\",\"accountType\":\"Savings\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"SGD\",\"openingAvlBalance\":84327.51},{\"accountNumber\":1234596790,\"accountName\":\"AUSavings933\",\"accountType\":\"Savings\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"AUD\",\"openingAvlBalance\":88005.93},{\"accountNumber\":1234596791,\"accountName\":\"AUCurrent433\",\"accountType\":\"Current\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"AUD\",\"openingAvlBalance\":38010.62},{\"accountNumber\":1234596792,\"accountName\":\"SGCurrent166\",\"accountType\":\"Current\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"SGD\",\"openingAvlBalance\":50664.65},{\"accountNumber\":1234596793,\"accountName\":\"AUCurrent374\",\"accountType\":\"Current\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"AUD\",\"openingAvlBalance\":41327.28},{\"accountNumber\":1234596794,\"accountName\":\"AUSavings938\",\"accountType\":\"Savings\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"AUD\",\"openingAvlBalance\":48928.79},{\"accountNumber\":1234596795,\"accountName\":\"SGSavings842\",\"accountType\":\"Savings\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"SGD\",\"openingAvlBalance\":72117.53},{\"accountNumber\":1234596796,\"accountName\":\"AUSavings253\",\"accountType\":\"Savings\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"AUD\",\"openingAvlBalance\":20588.16},{\"accountNumber\":1234596797,\"accountName\":\"AUCurrent754\",\"accountType\":\"Current\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"AUD\",\"openingAvlBalance\":88794.48},{\"accountNumber\":1234596798,\"accountName\":\"SGCurrent294\",\"accountType\":\"Current\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"SGD\",\"openingAvlBalance\":5906.55},{\"accountNumber\":1234596799,\"accountName\":\"AUCurrent591\",\"accountType\":\"Current\",\"balanceDate\":\"2018-11-07T13:00:00.000+00:00\",\"currency\":\"AUD\",\"openingAvlBalance\":92561.68}]\n"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAccountsByCustomerId_failed_badRequest() throws Exception {
        mockMvc.perform(get("/accounts/{customerId}", 1005L)
                        .contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"errorId\":\"E001\",\"message\":\"Customer not found\"}"))
                .andDo(MockMvcResultHandlers.print());
    }
}
