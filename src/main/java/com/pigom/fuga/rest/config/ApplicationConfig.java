package com.pigom.fuga.rest.config;

import com.pigom.fuga.rest.services.PlayerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Bean
    @Scope(value = "singleton")
    public PlayerRepository playerRepository() {
        return new PlayerRepository();
    }

}
