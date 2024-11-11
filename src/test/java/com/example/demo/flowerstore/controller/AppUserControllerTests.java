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

    private final String API_USERS = "/api/appusers";
    private final String EMAIL_1 = "user1@example.com";
    private final String EMAIL_2 = "user2@example.com";
    private final String NEW_EMAIL = "newuser@example.com";
    private final LocalDate DOB_1 = LocalDate.of(1990, 1, 1);
    private final LocalDate DOB_2 = LocalDate.of(1992, 2, 2);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserService appUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateAppUser_Success() throws Exception {
        AppUser newUser = new AppUser(NEW_EMAIL, DOB_1);
        Mockito.when(appUserService.create(ArgumentMatchers.any(AppUser.class)))
                .thenReturn(newUser);

        mockMvc.perform(MockMvcRequestBuilders.post(API_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email")
                        .value(NEW_EMAIL));
    }

    @Test
    void testListAppUsers() throws Exception {
        AppUser user1 = new AppUser(EMAIL_1, DOB_1);
        AppUser user2 = new AppUser(EMAIL_2, DOB_2);
        Mockito.when(appUserService.list()).thenReturn(List.of(user1, user2));

        mockMvc.perform(MockMvcRequestBuilders.get(API_USERS))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()")
                        .value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email")
                        .value(EMAIL_1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email")
                        .value(EMAIL_2));
    }
}