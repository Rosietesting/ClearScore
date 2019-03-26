package tests;

import PagesObjects.NavigationMenuComponent;
import PagesObjects.SavingsCalculatorPage;
import com.clearScore.test.config.DriverFactory;
import com.clearScore.test.scenario.BaseScenario;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import utils.Scores;
import static junit.framework.TestCase.fail;
import javax.inject.Inject;

public class SavingCalculatorTest extends BaseScenario {

    protected WebDriver driver;


    @Inject
    SavingsCalculatorPage savingsCalculatorPage = new SavingsCalculatorPage(driver);


    @Inject
    NavigationMenuComponent navigationMenuComponent = new NavigationMenuComponent(driver);

    @Inject
    Scores scores;

    @Value("${ui.savings.calculator.currentScoreSlider}")
    public String currentScoreSliderType;

    @Value("${ui.savings.calculator.goalScoreSlider}")
    public String goalScoreSliderType;




    @Before
    public void before(){

        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        savingsCalculatorPage.driver = this.driver;


    }

    @Test
    public void setSliderScores(){

        //GIVEN that the user navigates to the saving calculator
        navigationMenuComponent.driver = driver;
        navigationMenuComponent.goToSavingsCalculator();
        Integer currentScoreValue = 50;
        Integer goalScoreValue = 680;

        //WHEN the current score value is updated in the slider
        if (currentScoreValue >= 0 &&  currentScoreValue <= 700 ){

            savingsCalculatorPage.setCurrentScoreValue(currentScoreValue);
        }else{
            throw  new InvalidArgumentException(String.format("Incorrect slider input. Only scores between 0 and 700 are allowed"));
        }
        if (goalScoreValue >= 0 &&  goalScoreValue <= 700 ){

            savingsCalculatorPage.setGoalScoreValue(goalScoreValue);
        }else{
            throw  new InvalidArgumentException(String.format("Incorrect slider input. Only scores between 0 and 700 are allowed"));
        }
        //THEN the scores are correctly calculated
        scores = savingsCalculatorPage.retrieveCurrentScores();
        //AND the current averate Interest rate is correct
        if(!(scores.getCurrentAverageInterestRate().equals("36.5%"))){
            fail(String.format("Incorrect Current average score. Expected 36.5%%, found '%s'", scores.getCurrentAverageInterestRate()));
            driver.quit();
        }
        if(!(scores.getCurrentAnnualCost().equals("£849"))){
            fail(String.format("Incorrect annual cost. Expected £849, found '%s'", scores.getCurrentAnnualCost()));
            driver.quit();
        }
        if(!(scores.getCurrentCreditCardsAvailable().equals("22"))){
            fail(String.format("Incorrect current credit cards available. Expected 22, found '%s'", scores.getCurrentCreditCardsAvailable()));
            driver.quit();
        }
        if(!(scores.getGoalAverageInterestRate().equals("25%"))){
            fail(String.format("Incorrect goal average interest rate. Expected 25%% , found '%s'" , scores.getGoalAverageInterestRate()));
            driver.quit();
        }

        if(!(scores.getGoalAnnualCost().equals("£520"))){
            fail(String.format("Incorrect goal annual cost. Expected £520, found '%s'", scores.getGoalAnnualCost()));
            driver.quit();
        }
        if(!(scores.getGoalCreditCardsAvailable().equals("241"))){
            fail(String.format("Incorrect goal credit cards available. Expected 241, found '%s'", scores.getGoalCreditCardsAvailable()));
            driver.quit();
        }
        if(!(scores.getPotentialSavings().equals("£384"))){
            fail(String.format("Incorrect potential savings. Expected £384, found '%s'", scores.getPotentialSavings()));
            driver.quit();
        }


    }


}
