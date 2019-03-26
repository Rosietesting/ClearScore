package utils;

import org.springframework.stereotype.Service;

/**
 *
 * This class holds the values of the scores in the calculator page
 *
 */
@Service
public class Scores {

    private String currentAverageInterestRate;
    private String goalAverageInterestRate;
    private String currentAnnualCost;
    private String goalAnnualCost;
    private String currentCreditCardsAvailable;
    private String goalCreditCardsAvailable;
    private String potentialSavings;


    public String getCurrentAverageInterestRate() {
        return currentAverageInterestRate;
    }

    public void setCurrentAverageInterestRate(String currentAverageInterestRate) {
        this.currentAverageInterestRate = currentAverageInterestRate;
    }

    public String getPotentialSavings() {
        return potentialSavings;
    }

    public void setPotentialSavings(String potentialSavings) {
        this.potentialSavings = potentialSavings;
    }

    public String getGoalAverageInterestRate() {
        return goalAverageInterestRate;
    }

    public void setGoalAverageInterestRate(String goalAverageInterestRate) {
        this.goalAverageInterestRate = goalAverageInterestRate;
    }

    public String getCurrentAnnualCost() {
        return currentAnnualCost;
    }

    public void setCurrentAnnualCost(String currentAnnualCost) {
        this.currentAnnualCost = currentAnnualCost;
    }

    public String getGoalAnnualCost() {
        return goalAnnualCost;
    }

    public void setGoalAnnualCost(String goalAnnualCost) {
        this.goalAnnualCost = goalAnnualCost;
    }

    public String getCurrentCreditCardsAvailable() {
        return currentCreditCardsAvailable;
    }

    public void setCurrentCreditCardsAvailable(String currentCreditCardsAvailable) {
        this.currentCreditCardsAvailable = currentCreditCardsAvailable;
    }

    public String getGoalCreditCardsAvailable() {
        return goalCreditCardsAvailable;
    }

    public void setGoalCreditCardsAvailable(String goalCreditCardsAvailable) {
        this.goalCreditCardsAvailable = goalCreditCardsAvailable;
    }
}
