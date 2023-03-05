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
public class TransactionControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTransactionByAccountId_success() throws Exception {
        mockMvc.perform(get("/accounts/{accountId}/transactions", 1234596799L)
                        .param("page", "0")
                        .param("size", "50")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"totalPages\":1,\"totalElements\":12,\"transactions\":[{\"id\":1,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":9540.98,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":2,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":7497.82,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":3,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":5564.79,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":4,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":8136.18,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":5,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":9442.46,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":6,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":7614.45,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":7,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":3311.55,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":8,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":9186.09,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":9,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":1905.86,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":10,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":197.78,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":11,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":8430.49,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null},{\"id\":12,\"valueDate\":\"2012-01-11T13:00:00Z\",\"currency\":\"USD\",\"debitAmount\":null,\"creditAmount\":8.33,\"drCrIndicator\":\"Credit\",\"transactionNarrative\":null}]}\n"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getTransactionByAccountId_failed_badRequest() throws Exception {
        mockMvc.perform(get("/accounts/{accountId}/transactions", 1L)
                        .param("page", "0")
                        .param("size", "50")
                        .contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"errorId\":\"E002\",\"message\":\"Account not found\"}"))
                .andDo(MockMvcResultHandlers.print());
    }
}
