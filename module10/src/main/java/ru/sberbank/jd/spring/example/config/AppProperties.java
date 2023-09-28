package ru.sberbank.jd.spring.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {
    private String value;
    private String mySuperValue;
    private DatabaseProperties database;

    @Getter
    @Setter
    static public class DatabaseProperties {
        private String databaseUrl;
        private boolean mock;
    }
}
