package com.clearScore.rest;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import static io.restassured.RestAssured.given;

/**
 * This class implements the login task and has the methods to create the payload for login and the execution method that
 * sends the request to the API
 */
public class RestLoginTask implements LoginTask {

    private String responseType;

    @Value("${api.login.invalidEmail}")
    private String invalidEmail;

    @Value("${api.login.invalidPassword}")
    private String invalidPassword;

    @Value("${api.server.loginUrl}")
    private String UrlLogin;

    private final Logger LOGGER = LoggerFactory.getLogger(RestLoginTask.class);

    private RestConfig restConfig;
    private Login login;



    public RestLoginTask(RestConfig restConfig) {

        this.restConfig = restConfig;
        this.login = new Login();
        this.login.setAnonnymousId("98ab47a1-364e-4d1e-a3d7-a00c2050b16e");
        this.login.setDevice("desktop");

    }

    /**
     * This method performs the request to the API
     * @return the response of the request
     */
    public Response Execute() {

            Response response =
                    given()
                            .contentType(restConfig.getApplicationContent())
                            .body(login)
                            .when()
                            .post("https://api.clearscore.com/caesium-api/users/signIn")
                            .then()
                            .extract().response();

       try {
               return response;
        }catch (Exception e){
           LOGGER.error("Failed to get reponse", e);
           throw new RuntimeException(e);
       }

    }

    /**
     * This method set the email to the payload
     * @param email
     * @return loginTask object that serves the login payload
     */
    public LoginTask withEmail(String email) {
        this.login.setEmail(email);
        return this;
    }

    /**
     * This method set the password to the payload
     * @param password
     * @return
     */
    public LoginTask withPassword(String password) {
        this.login.setPassword(password);
        return this;
    }


}