package com.clearScore.rest;

import io.restassured.response.Response;

/**
 * This interface is intended to create API requests  and return a Response (Restassured object)
 * @param <T>
 */
public interface Execute <T extends Execute> {

    Response Execute();
}
