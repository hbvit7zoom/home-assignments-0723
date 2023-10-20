package ru.sberbank.jd.module13.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.module13.user.model.User;
import ru.sberbank.jd.module13.user.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> getByLogin(@NonNull String username) {
        return userRepository.findUserByLogin(username);
    }
}
