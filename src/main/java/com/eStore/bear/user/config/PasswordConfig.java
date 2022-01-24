package com.eStore.bear.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "password.hashing.algo.argon2")
@Data
public class PasswordConfig {

    private int type;
    private int saltLength;
    private int hashLength;
    private int iterations;
    private int memory;
    private int parallelism;
}
