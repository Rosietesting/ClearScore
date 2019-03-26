package com.clearScore.rest;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * This method records all tasks in the login function and  return a new instance of the task
 */
@Component
public class RestLoginTasks implements LoginTasks{

    @Inject
    RestConfig restConfig;


    public LoginTask login() {
        return new RestLoginTask(restConfig);
    }
}
