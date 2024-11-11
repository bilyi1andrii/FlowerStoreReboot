package com.example.demo.flowerstore.controller;

import com.example.demo.flowerstore.model.AppUser;
import com.example.demo.flowerstore.service.AppUserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import org.mockito.ArgumentMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AppUserController.class)
public class AppUserControllerTests {

    private final String apiUsers = "/api/appusers";
    private final String emailOne = "user1@example.com";
    private final String emailTwo = "user2@example.com";
    private final String newEmail = "newuser@example.com";
    private final LocalDate dobOne = LocalDate.of(1990, 1, 1);
    private final LocalDate dobTwo = LocalDate.of(1992, 2, 2);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserService appUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateAppUserSuccess() throws Exception {
        AppUser newUser = new AppUser(newEmail, dobOne);
        Mockito.when(appUserService.create(ArgumentMatchers.any(AppUser.class)))
                .thenReturn(newUser);

        mockMvc.perform(MockMvcRequestBuilders.post(apiUsers)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email")
                        .value(newEmail));
    }

    @Test
    void testListAppUsers() throws Exception {
        AppUser userOne = new AppUser(emailOne, dobOne);
        AppUser userTwo = new AppUser(emailTwo, dobTwo);
        Mockito.when(appUserService.list())
        .thenReturn(List.of(userOne, userTwo));

        mockMvc.perform(MockMvcRequestBuilders.get(apiUsers))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()")
                        .value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email")
                        .value(emailOne))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email")
                        .value(emailTwo));
    }
}