package ru.sberbank.jd.spring.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.sberbank.jd.spring.example.A;

@RequiredArgsConstructor
@Slf4j
public class ExternalRestServiceClientImpl implements ExternalRestServiceClient {
    private final A a;
    @Override
    public void execute() {
        log.info("ExternalRestServiceClientImpl");
    }
}
