package com.clearScore.rest;

/**
 * This interface has the methods that Login can perform in the API
 */
public interface LoginTask extends Execute<LoginTask> {

    LoginTask withEmail(String email);

    LoginTask withPassword(String password);
}

