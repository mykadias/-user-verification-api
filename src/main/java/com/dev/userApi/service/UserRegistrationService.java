package com.dev.userApi.service;

import com.dev.userApi.entity.User;
import com.dev.userApi.entity.VerificationToken;
import com.dev.userApi.repository.UserRepository;
import com.dev.userApi.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private EmailService emailService;

    public void registerUser(User user){
        user.setEmailVerified(false);
        userRepository.save(user);

        VerificationToken token = new VerificationToken(user);
        tokenRepository.save(token);

        emailService.sendVerificationEmail(user.getEmail(), token.getToken());

    }
}
