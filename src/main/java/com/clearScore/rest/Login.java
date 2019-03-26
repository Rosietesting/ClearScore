package com.clearScore.rest;

import org.springframework.stereotype.Component;

/**
 * This component will hold the payload to send the login request to the API
 */
@Component
public class Login {

    private String anonymousId;
    private String device;
    private String email;
    private String password;



    public String getAnonnymousId() {
        return anonymousId;
    }

    public void setAnonnymousId(String anonnymousId) {
        this.anonymousId = anonnymousId;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
