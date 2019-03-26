package PagesObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.springframework.stereotype.Service;
import utils.Scores;

import javax.inject.Inject;


@Service
public class SavingsCalculatorPage {

    @Inject
    Scores scores;


    public WebDriver driver;

    public SavingsCalculatorPage(WebDriver driver) {
        this.driver = driver;

    }

    //Xpaths definitions in savings calculator page
    private static final By currentScoreSlider = By.cssSelector("input.js-range-current");
    private static final By goalScoreSlider = By.cssSelector("input.js-range-goal");
    private static final By currentInterestAverageRate = By.cssSelector("td.js-current-average-rate");
    private static final By currentAnnualCost = By.cssSelector("td.js-current-annual-cost");
    private static final By currentCreditCardsAvailable = By.cssSelector("td.js-current-cc-available");
    private static final By goalInterestAverageRate = By.cssSelector("td.js-goal-average-rate");
    private static final By goalAnnualCost = By.cssSelector("td.js-goal-annual-cost");
    private static final By goalCreditCardsAvailable = By.cssSelector("td.js-goal-cc-available");
    private static final By potentialSaving = By.cssSelector("span.js-total-saving-number");


    /**
     *
     * This method set the value for the current score slider
     * @param requiredValue is the value that is used to update the slider
     */
    public void setCurrentScoreValue( Integer requiredValue) {

        WebElement slider;

        try {
              slider = driver.findElement(currentScoreSlider);

        }catch (NoSuchElementException e){

            throw new RuntimeException(String.format("Current score slider not found"));
        }

        Assert.assertTrue("Incorrect slider input",(requiredValue >= 0 && requiredValue <= 700));
        try {

            Integer currentValue = Integer.valueOf(slider.getAttribute("value"));
            Integer positions = requiredValue - currentValue;
            Keys directionKey;
            if (positions < 0) {

                 directionKey = Keys.ARROW_LEFT;
            }else {

                 directionKey = Keys.ARROW_RIGHT;
            }

            for (int i = 0; i < Math.abs(positions); i++) {

                    slider.sendKeys(directionKey);
            }

        }catch (Exception e){
            throw new NoSuchElementException("Slider could not be updated", e);
        }

        Assert.assertTrue(Integer.valueOf(slider.getAttribute("value")).equals(requiredValue));

    }


    /**
     * This method set the value for the goal score slider
     * @param requiredValue
     */
    public void setGoalScoreValue( Integer requiredValue) {

        WebElement slider;

        try {
            slider = driver.findElement(goalScoreSlider);

        }catch (NoSuchElementException e){

            throw new RuntimeException(String.format("Current score slider not found"));
        }

        try {

            Integer currentValue = Integer.valueOf(slider.getAttribute("value"));
            Integer positions = requiredValue - currentValue;
            Keys directionKey;
            if (positions < 0) {

                directionKey = Keys.ARROW_LEFT;
            }else {

                directionKey = Keys.ARROW_RIGHT;
            }

            for (int i = 0; i < Math.abs(positions); i++) {

                slider.sendKeys(directionKey);
            }

        }catch (Exception e){
            throw new NoSuchElementException("Slider could not be updated", e);
        }

        Assert.assertTrue(Integer.valueOf(slider.getAttribute("value")).equals(requiredValue));

    }


    /**
     * This method finds the current score , goal scores and the potential savings in the calculator page
     *
     *
     * @return score object
     *
     */
    public Scores retrieveCurrentScores(){

        //get current average interest rate
        scores.setCurrentAverageInterestRate(driver.findElement(currentInterestAverageRate).getText());
        scores.setCurrentAnnualCost(driver.findElement(currentAnnualCost).getText());
        scores.setCurrentCreditCardsAvailable(driver.findElement(currentCreditCardsAvailable).getText());
        scores.setGoalAverageInterestRate(driver.findElement(goalInterestAverageRate).getText());
        scores.setGoalAnnualCost(driver.findElement(goalAnnualCost).getText());
        scores.setGoalCreditCardsAvailable(driver.findElement(goalCreditCardsAvailable).getText());
        scores.setPotentialSavings(driver.findElement(potentialSaving).getText());
        return scores;
    }





}
