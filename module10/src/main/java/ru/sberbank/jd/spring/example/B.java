package ru.sberbank.jd.spring.example;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.sberbank.jd.spring.example.config.AppProperties;
import ru.sberbank.jd.spring.example.service.ExternalRestServiceClient;
import ru.sberbank.jd.spring.example.service.ExternalRestServiceClientImpl;

@Component
@Slf4j
@RequiredArgsConstructor
// spring-cloud-sleuth
public class B {
//    private final Logger log = LoggerFactory.getLogger(B.class);
    private final A a;

    private final ExternalRestServiceClient externalRestServiceClient;

    @Value("${app.value}")
    private String appValue;

    private final AppProperties properties;

//    public B(A a, @Qualifier("externalRestServiceClientStub") ExternalRestServiceClient restServiceClient) {
//        this.a = a;
//        this.restServiceClient = restServiceClient;
//    }

    @PostConstruct
    public void doSmth() {
        log.info(a.getContent());
        log.debug("debug log");
        log.info("appValue = {}", appValue);
        log.info("appProperties.value = {}", properties.getValue());
        log.info("dbUrl = {}, mock = {}", properties.getDatabase().getDatabaseUrl(), properties.getDatabase().isMock());
    }
}
