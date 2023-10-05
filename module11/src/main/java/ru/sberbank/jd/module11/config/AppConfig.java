package ru.sberbank.jd.module11.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.sberbank.jd.module11.service.TaskService;
import ru.sberbank.jd.module11.service.TaskServiceErrorImpl;
import ru.sberbank.jd.module11.service.TaskServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    @Profile("!test-error")
//    @ConditionalOnProperty(name = "app.task-service", havingValue = "default")
    public TaskService defaultTaskService() {
        return new TaskServiceImpl();
    }

    @Bean
//    @ConditionalOnProperty(name = "app.task-service", havingValue = "error")
    @Profile("test-error")
    public TaskService errorTaskService() {
        return new TaskServiceErrorImpl();
    }
}
