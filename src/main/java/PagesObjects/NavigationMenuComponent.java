package PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.inject.Inject;
import java.util.List;

public class NavigationMenuComponent {

    public WebDriver driver;

    public NavigationMenuComponent(WebDriver driver) {
        this.driver = driver;

    }

    @Inject
    CookieNotificationComponent cookienNotificationComponent = new CookieNotificationComponent(driver);



    private static final By footerElement = By.xpath(".//footer[contains(@class, 'cs-footer')]");
    private static final By savingCalculator = By.linkText("Savings Calculator");

    /**
     * This method goes to the calculator page
     */
    public void goToSavingsCalculator(){

        cookienNotificationComponent.driver = this.driver;
        cookienNotificationComponent.dismissCookieNotification();
        try {

            WebElement footer = driver.findElement(footerElement);
            List<WebElement> sections = footer.findElements(By.xpath(".//div[contains(@class,'center left-m text-small')]/div/section"));
            List<WebElement> dicoverMenu = sections.get(4).findElements(By.xpath(".//li[contains(@class,'footer__link ')]"));
            dicoverMenu.get(2).findElement(savingCalculator).click();

        }catch (Exception e){
            throw  new java.util.NoSuchElementException("Saving calculator button not found");
        }
    }

}
