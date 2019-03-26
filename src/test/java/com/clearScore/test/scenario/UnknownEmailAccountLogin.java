package com.clearScore.test.scenario;

import com.clearScore.rest.Login;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import sun.rmi.runtime.Log;

import javax.inject.Inject;

/**
 * This class contains the test related to the login function
 */
public class UnknownEmailAccountLogin extends BaseScenario {

    @Inject
    ScenarioGenerator sg;

    @Inject
    Login login;


    @Value("${api.login.validEmail}")
    private String validEmail;

    @Value("${api.login.password}")
    private String password;


    @Test
    public void unknownEmailAcount(){

        Response response = sg.loginTasksBuilder()
                .login()
                .withEmail(validEmail)
                .withPassword(password)
                .Execute();
        Assert.assertEquals(response.statusCode(), 403);
        Assert.assertTrue(response.jsonPath().get("validEmail").toString() == "true");


    }

}
