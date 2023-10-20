package ru.sberbank.jd.module13.service;

import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.module13.controller.jwt.JwtRequest;
import ru.sberbank.jd.module13.controller.jwt.JwtResponse;
import ru.sberbank.jd.module13.model.JwtAuthentication;
import ru.sberbank.jd.module13.user.model.User;
import ru.sberbank.jd.module13.user.service.UserService;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final Map<String, String> refreshStorage = new HashMap<>();

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @SneakyThrows
    public JwtResponse login(JwtRequest authRequest) {
        final User user = userService.getByLogin(authRequest.getUsername())
                .orElseThrow(() -> new AuthException("User was not found"));
        if (user.getPassword().equals(authRequest.getPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getLogin(), refreshToken);

            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new AuthException("Wrong password for user " + authRequest.getUsername());
        }
    }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
