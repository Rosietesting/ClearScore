package PagesObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * This class have the elements and methods in the home page that allows the different tests in the home page
 */
public class CookieNotificationComponent {


    public WebDriver driver;


    public CookieNotificationComponent(WebDriver driver) {
        this.driver = driver;
    }

    //xpaths definitions in home page

    private static final By cookieFrameElement = By.xpath(".//div[contains(@class, 'cs-cookie show')]");
    private static final By cookieTextElement = By.xpath(".//div/div/p");
    private static final By cookieOptions = By.xpath(".//div/div");
    private static final By noProblemButton = By.xpath(".//p/span");
    private static final By divSections = By.xpath(".//div[contains(@class,'center left-m text-small')]/div/section");
    WebElement cookieElement;


    /**
     * This method find the cookies notification in the home page of clear score
     *
     * @return the text of the cookie notification
     */
    public String getNotificationMessage() {

        String cookieText = "";

        try {
            cookieElement = driver.findElement(cookieFrameElement);
            Assert.assertTrue(checkCookieNotificationVisible());
            cookieText = cookieElement.findElement(cookieTextElement).getText();

        } catch (Exception e) {

            throw new NoSuchElementException("Cookie text not found", e);
        }

        return cookieText;
    }


    /**
     *
     * This method dismiss the cookie notification
     */
    public void dismissCookieNotification() {

        try {

            cookieElement = getCookieNotificationElement();
            List<WebElement> list = cookieElement.findElements(cookieOptions);
            list.get(1).findElement(noProblemButton).click();


        } catch (Exception e) {

            throw new NoSuchElementException("Not able to dismiss the cooie notification", e);
        }


    }

    /**
     * This method check if  the cookie notification is visible
     * @return true if the notification is displayed or false if it is not visible
     */
    public Boolean checkCookieNotificationVisible(){

        Boolean cookieVisible;

        if (cookieElement.isDisplayed()){
            cookieVisible =  true;
        }else {
            cookieVisible = false;
        }
        return cookieVisible;

    }

    /**
     * This method get the cookie notification  and
     * @return  the cookie
     */
    private WebElement getCookieNotificationElement() {

        WebElement cookieElement;

        try {

             cookieElement = driver.findElement(cookieFrameElement);

        } catch (Exception e) {

            throw new NoSuchElementException("Cooking notification not found", e);

        }
        return cookieElement;
    }

}
