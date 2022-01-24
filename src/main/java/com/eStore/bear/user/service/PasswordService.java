package com.eStore.bear.user.service;

import com.eStore.bear.user.config.PasswordConfig;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private PasswordConfig passwordConfig;
    private final Argon2 argon2;

    public PasswordService(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
        argon2 = getArgon2Instance();
    }

    public String securePassword(String password) {

        return argon2.hash(passwordConfig.getIterations(), passwordConfig.getMemory(), passwordConfig.getParallelism(),
                password.toCharArray());
    }

    public boolean validatePassword(String hash, String password) {
        return argon2.verify(hash, password.toCharArray());
    }

    private Argon2 getArgon2Instance() {
        Argon2Factory.Argon2Types type = Argon2Factory.Argon2Types.ARGON2d;
        if(passwordConfig.getType() == 1) {
            type = Argon2Factory.Argon2Types.ARGON2i;
        } else if(passwordConfig.getType() == 2) {
            type = Argon2Factory.Argon2Types.ARGON2d;
        }
        return Argon2Factory.create(type, passwordConfig.getSaltLength(), passwordConfig.getHashLength());
    }
}
