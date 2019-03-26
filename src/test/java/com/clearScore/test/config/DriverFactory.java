package com.clearScore.test.config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    protected static WebDriver driver;

    public DriverFactory() {

          initialize();

    }
    private final Logger LOGGER = LoggerFactory.getLogger(DriverFactory.class);

    String localDir = System.getProperty("user.dir");
    File driverPath = new File(localDir + "\\src\\test\\resources\\driver\\chromedriver.exe");
    private String browser = System.getProperty("browser", "chrome");
    private String driverExec = (String) System.getProperty("driverExec", String.valueOf(driverPath));


    public void initialize() {

        System.setProperty("webdriver.chrome.driver", driverExec);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String url = "http://" + "www.clearscore.com";
        driver.get(url);

    }

    public WebDriver getDriver() {
        return driver;
    }




}
