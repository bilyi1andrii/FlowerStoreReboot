package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

	@Autowired
    private ApplicationContext applicationContext;

    private static final String EXPECTED_COLOR1 = "#FF0000";
    private static final String EXPECTED_COLOR2 = "#0000FF";
    private static final int EXPECTED_SEPAL_LENGTH1 = 12;
    private static final int EXPECTED_SEPAL_LENGTH2 = 7;
    private static final double EXPECTED_PRICE1 = 30.0;
    private static final double EXPECTED_PRICE2 = 60.0;
    private static final String EXPECTED_TYPE1 = "TULIP";
    private static final String EXPECTED_TYPE2 = "ROSE";

    @Test
    void testGetFlowers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/flowers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].color").value(EXPECTED_COLOR1))
                .andExpect(jsonPath("$[0].sepalLength").value(EXPECTED_SEPAL_LENGTH1))
                .andExpect(jsonPath("$[0].price").value(EXPECTED_PRICE1))
                .andExpect(jsonPath("$[0].flowerType").value(EXPECTED_TYPE1))
                .andExpect(jsonPath("$[1].color").value(EXPECTED_COLOR2))
                .andExpect(jsonPath("$[1].sepalLength").value(EXPECTED_SEPAL_LENGTH2))
                .andExpect(jsonPath("$[1].price").value(EXPECTED_PRICE2))
                .andExpect(jsonPath("$[1].flowerType").value(EXPECTED_TYPE2));
    }

    @Test
    void contextLoads() {
        assertNotNull(applicationContext);
    }
}
