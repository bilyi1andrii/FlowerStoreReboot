package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    private static final String COLOR_RED = "#FF0000";
    private static final String COLOR_BLUE = "#0000FF";
    private static final int SEPAL_LENGTH_TULIP = 12;
    private static final int SEPAL_LENGTH_ROSE = 7;
    private static final double PRICE_TULIP = 30.0;
    private static final double PRICE_ROSE = 60.0;
    private static final String TYPE_TULIP = "TULIP";
    private static final String TYPE_ROSE = "ROSE";

    @Test
    void testGetFlowers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/flowers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].color").value(COLOR_RED))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sepalLength")
                        .value(SEPAL_LENGTH_TULIP))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price")
                        .value(PRICE_TULIP))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].flowerType")
                        .value(TYPE_TULIP))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].color").value(COLOR_BLUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].sepalLength")
                        .value(SEPAL_LENGTH_ROSE))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price")
                        .value(PRICE_ROSE))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].flowerType")
                        .value(TYPE_ROSE));
    }

    @Test
    void contextLoads() {
        org.junit.jupiter.api.Assertions.assertNotNull(applicationContext);
    }
}