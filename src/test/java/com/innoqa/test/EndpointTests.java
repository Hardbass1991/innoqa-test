package com.innoqa.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innoqa.test.controller.PricelistController;
import com.innoqa.test.model.Pricelist;
import com.innoqa.test.service.PricelistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@WebMvcTest(PricelistController.class)
@Import(PricelistController.class)
public class EndpointTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PricelistService service;
    @Autowired
    private ObjectMapper objectMapper;
    private Pricelist pricelist;

    @Test
    public void ConsultaGetTest() throws Exception {
        given(service.getPricelistCustom(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any()))
                .willAnswer((invocation -> invocation.getArgument(0)));
        String requestURI1 = "/api/pricelists/"
                + "?queryDateTime=2020-06-14T10:00:00"
                + "&queryBrandId=1"
                + "&queryProductId=35455";
        ResultActions response1 = mockMvc.perform(get(requestURI1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        String requestURI2 = "/api/pricelists/"
                + "?queryDateTime=2020-06-14T16:00:00"
                + "&queryBrandId=1"
                + "&queryProductId=35455";
        ResultActions response2 = mockMvc.perform(get(requestURI2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        String requestURI3 = "/api/pricelists/"
                + "?queryDateTime=2020-06-14T21:00:00"
                + "&queryBrandId=1"
                + "&queryProductId=35455";
        ResultActions response3 = mockMvc.perform(get(requestURI3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        String requestURI4 = "/api/pricelists/"
                + "?queryDateTime=2020-06-14T16:00:00"
                + "&queryBrandId=1"
                + "&queryProductId=35455";
        ResultActions response4 = mockMvc.perform(get(requestURI4)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        String requestURI5 = "/api/pricelists/"
                + "?queryDateTime=2020-06-14T16:00:00"
                + "&queryBrandId=1"
                + "&queryProductId=35455";
        ResultActions response5 = mockMvc.perform(get(requestURI5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}