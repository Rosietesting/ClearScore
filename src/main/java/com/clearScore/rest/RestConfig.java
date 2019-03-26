package com.clearScore.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/*
This class has the basic configuration needed to send requests to the API
 */
@Component
public class RestConfig {

    @Value("${api.server.baseUrl}")
    private String baseUrl;

    @Value("${api.server.contentType}")
    private String applicationContent;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApplicationContent() {
        return applicationContent;
    }

    public void setApplicationContent(String applicationContent) {
        this.applicationContent = applicationContent;
    }
}
