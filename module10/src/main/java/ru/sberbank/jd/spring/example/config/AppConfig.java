package ru.sberbank.jd.spring.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sberbank.jd.spring.example.A;
import ru.sberbank.jd.spring.example.service.ExternalRestServiceClient;
import ru.sberbank.jd.spring.example.service.ExternalRestServiceClientImpl;
import ru.sberbank.jd.spring.example.service.ExternalRestServiceClientStub;

@Configuration
@EnableConfigurationProperties(value = AppProperties.class)
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "app.database.mock", havingValue = "true")
    public ExternalRestServiceClient externalRestServiceClient(A a) {
        return new ExternalRestServiceClientImpl(a);
    }

    @Bean
    @ConditionalOnMissingBean
//    @Scope("prototype")
    public ExternalRestServiceClient externalRestServiceClientStub() {
        return new ExternalRestServiceClientStub();
    }

    @Configuration
    @ConditionalOnProperty(name = "app.database.mock", havingValue = "true")
    static public class MockDbConfig {

    }
}
