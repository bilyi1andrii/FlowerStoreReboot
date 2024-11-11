package com.example.demo.flowerstore.service;

import com.example.demo.flowerstore.exception.UserAlreadyExistsException;
import com.example.demo.flowerstore.model.AppUser;
import com.example.demo.flowerstore.repository.AppUserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class AppUserServiceTests {

    private static final String EMAIL_NEW = "test@example.com";
    private static final String EMAIL_EXISTING = "existing@example.com";
    private static final String EMAIL_USER_ONE = "user1@example.com";
    private static final String EMAIL_USER_TWO = "user2@example.com";
    private static final LocalDate DOB_NEW_USER
    = LocalDate.of(1990, 1, 1);
    private static final LocalDate DOB_EXISTING_USER
    = LocalDate.of(1985, 5, 20);
    private static final LocalDate DOB_USER_ONE
    = LocalDate.of(1990, 1, 1);
    private static final LocalDate DOB_USER_TWO
    = LocalDate.of(1992, 2, 2);

    @Mock
    private AppUserRepository appUserRepository;

    @InjectMocks
    private AppUserService appUserService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUserSuccess() {
        AppUser newUser = new AppUser(EMAIL_NEW, DOB_NEW_USER);
        Mockito.when(appUserRepository.findUserByEmail(EMAIL_NEW))
                .thenReturn(Optional.empty());
        Mockito.when(appUserRepository.save(
                ArgumentMatchers.any(AppUser.class)))
                .thenReturn(newUser);

        AppUser createdUser = appUserService.create(newUser);

        Assertions.assertNotNull(createdUser);
        Assertions.assertEquals(EMAIL_NEW, createdUser.getEmail());
        Mockito.verify(appUserRepository,
        Mockito.times(1)).save(newUser);
    }

    @Test
    void testCreateUserAlreadyExists() {
        AppUser existingUser = new AppUser(EMAIL_EXISTING, DOB_EXISTING_USER);
        Mockito.when(appUserRepository.findUserByEmail(EMAIL_EXISTING))
                .thenReturn(Optional.of(existingUser));

        UserAlreadyExistsException exception = Assertions.assertThrows(
                UserAlreadyExistsException.class,
                () -> appUserService.create(existingUser)
        );

        Assertions.assertEquals(
                "User with email " + EMAIL_EXISTING + " already exists",
                exception.getMessage());
        Mockito.verify(appUserRepository, Mockito.never())
                .save(ArgumentMatchers.any(AppUser.class));
    }

    @Test
    void testListUsers() {
        AppUser userOne = new AppUser(EMAIL_USER_ONE, DOB_USER_ONE);
        AppUser userTwo = new AppUser(EMAIL_USER_TWO, DOB_USER_TWO);
        Mockito.when(appUserRepository.findAll())
                .thenReturn(List.of(userOne, userTwo));

        List<AppUser> users = appUserService.list();

        Assertions.assertNotNull(users);
        Assertions.assertEquals(2, users.size());
        Mockito.verify(appUserRepository,
        Mockito.times(1)).findAll();
    }
}