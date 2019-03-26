package tests;

import PagesObjects.CookieNotificationComponent;
import com.clearScore.test.config.DriverFactory;
import com.clearScore.test.scenario.BaseScenario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.springframework.beans.factory.annotation.Value;
import utils.BrowserCookiesHelper;

import static junit.framework.TestCase.fail;

import javax.inject.Inject;


public class CookieNotificationTest extends BaseScenario {

    protected WebDriver driver;


    @Inject
    CookieNotificationComponent cookienNotificationComponent = new CookieNotificationComponent(driver);

    @Value("${ui.cookieNotification.cookieText}")
    private String cookieText;

    @Value("${ui.cookieNotification.firstVisitCookie}")
    private String firstVisitCookie;

    @Value("${ui.cookieNotification.visitedSite}")
    private String visitedSiteCookie;


    @Value("${ui.cookieNotification.acceptCookies}")
    private String acceptCookies;

    @Value("${ui.cookieNotification.person}")
    private String personCookies;



    @Before
    public void before() {

        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        cookienNotificationComponent.driver = this.driver;

    }


    @Test
    public void cookieNotificationIsPresent() {

        Assert.assertEquals("Check that the notification message is displayed" ,
                cookieText, cookienNotificationComponent.getNotificationMessage());

    }


    @Test
    public void cookieNotificationCanBeDismissed() {

        cookienNotificationComponent.dismissCookieNotification();
        // Check if the no problem icon can be clicked to dismiss the cookie notification
        Assert.assertTrue("Check that the Cookies Notification is no longer displayed",
                cookienNotificationComponent.checkCookieNotificationVisible() == false);

    }

    @Test
    public void checkCookieAreSet() {
        cookienNotificationComponent.dismissCookieNotification();
        // Check First visit cookie is set
        if (BrowserCookiesHelper.hasNamedCookie(driver, firstVisitCookie) == false) {

            throw new RuntimeException(String.format("The browser does not have a cookie named '%s'", firstVisitCookie));

        } else {
            //Confirm that the cookis has a value
            BrowserCookiesHelper.getCookieValue(driver, firstVisitCookie);

        }
        // check person cookie is set
        if (BrowserCookiesHelper.hasNamedCookie(driver, visitedSiteCookie) == false) {

            throw new RuntimeException(String.format("The browser does not have a cookie named '%s'", visitedSiteCookie));

        }else{
            //Confirm that the cookis has a value
            BrowserCookiesHelper.hasNamedCookie(driver, visitedSiteCookie);
        }


        if (BrowserCookiesHelper.hasNamedCookie(driver, acceptCookies) == false) {

            throw new RuntimeException(String.format("The browser does not have a cookie named '%s'", acceptCookies));

        }else{
            //Confirm that the cookis has a value
            BrowserCookiesHelper.hasNamedCookie(driver, acceptCookies);
        }
        if (BrowserCookiesHelper.hasNamedCookie(driver, personCookies) == false) {

            throw new RuntimeException(String.format("The browser does not have a cookie named '%s'", personCookies));

        }else{
            //Confirm that the cookis has a value
            BrowserCookiesHelper.hasNamedCookie(driver, personCookies);
        }
    }


    @After
    public void after(){
        driver.quit();
        driver = null;

    }

}