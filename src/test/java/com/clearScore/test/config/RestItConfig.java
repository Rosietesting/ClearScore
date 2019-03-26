package com.clearScore.test.config;

import PagesObjects.CookieNotificationComponent;
import PagesObjects.NavigationMenuComponent;
import PagesObjects.SavingsCalculatorPage;
import com.clearScore.rest.Login;
import com.clearScore.rest.RestConfig;
import com.clearScore.rest.RestLoginTasks;
import com.clearScore.test.scenario.ScenarioGenerator;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import utils.Scores;

/**
 * This class defines the beans needed to be used in the aplication
 */
@Configuration
@PropertySource({"classpath:test.properties"})
public class RestItConfig {

    WebDriver driver;

    @Bean
    public ScenarioGenerator scenarioGenerator(){
        return new ScenarioGenerator (ScenarioGenerator.ExecutionType.REST);
    }

    @Bean
    public Scores scores(){
        return new Scores();
    }

    @Bean
    public SavingsCalculatorPage savingsCalculator(){
        return  new SavingsCalculatorPage(driver);
    }

    @Bean
    public CookieNotificationComponent cookieNotificationComponent(){
        return new CookieNotificationComponent(driver);
    }

    @Bean
    public NavigationMenuComponent navigationMenuComponent (){
        return new NavigationMenuComponent(driver);
    }

    @Bean
    public RestConfig restConfig(){
        return new RestConfig();
    }

    @Bean
    public RestLoginTasks restLogingTasks(){
        return new RestLoginTasks();
    }

    @Bean
    public Login login(){
        return new Login();
    }


}
