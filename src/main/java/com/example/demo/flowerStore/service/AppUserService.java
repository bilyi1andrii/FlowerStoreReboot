package com.example.demo.flowerstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.flowerstore.repository.AppUserRepository;
import com.example.demo.flowerstore.exception.UserAlreadyExistsException;
import com.example.demo.flowerstore.model.AppUser;

@Service
public class AppUserService {

    public final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> list() {
        return appUserRepository.findAll();
    }

    public AppUser create(AppUser appUser) {
        Optional<AppUser> existingUser = appUserRepository
        .findUserByEmail(appUser.getEmail());

        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email "
            + appUser.getEmail() + " already exists");
        }
        return appUserRepository.save(appUser);
    }
}