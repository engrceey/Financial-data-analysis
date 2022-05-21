package com.pectusfinance.financialrecord.controllers;

import com.pectusfinance.financialrecord.service.ExpansesService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class ExpansesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpansesService expansesService;

    @BeforeAll
    void setUp() {
    }

    @Test
    void getExpanses() {
    }

    @Test
    void getExpansesSorted() {
    }

    @Test
    void filterExpansesByMultiFields() {
    }

    @Test
    void getExpansesSortedByOneOrMoreFields() {
    }

    @Test
    void testGetExpanses() {
    }

//    @Test
//    void shouldGetDefaultWelcomeMessage() throws Exception {
//        when(welcomeService.getWelcomeMessage("Stranger")).thenReturn("Welcome Stranger!");
//        mockMvc.perform(get("/welcome"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Welcome Stranger!")));
//        verify(welcomeService).getWelcomeMessage("Stranger");
//    }
//
//    @Test
//    void shouldGetCustomWelcomeMessage() throws Exception {
//        when(welcomeService.getWelcomeMessage("John")).thenReturn("Welcome John!");
//        mockMvc.perform(get("/welcome?name=John"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Welcome John!")));
//        verify(welcomeService).getWelcomeMessage("John");
//    }
}