package ru.sberbank.jd.spring.example.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExternalRestServiceClientStub implements ExternalRestServiceClient {
    @Override
    public void execute() {
        log.info("ExternalRestServiceClientStub");
    }
}
