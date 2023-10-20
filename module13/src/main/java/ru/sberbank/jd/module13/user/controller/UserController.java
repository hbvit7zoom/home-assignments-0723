package ru.sberbank.jd.module13.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.jd.module13.model.JwtAuthentication;
import ru.sberbank.jd.module13.service.AuthService;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;

    @PreAuthorize("hasAuthority('READ_USER')")
    @GetMapping("user")
    public ResponseEntity<String> getUser() {
        final JwtAuthentication autInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + autInfo.getPrincipal());
    }

}
