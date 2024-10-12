package OpenMRS;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenMRS_Project extends BaseDriver {

    @Test (priority = 1)
    public void IncorrectEntry() {
        US_Elements locators = new US_Elements();

        driver.get("https://openmrs.org");

        locators.languageOption.click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.choosingLanguage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locators.demoButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locators.exOpenMRS2Button)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locators.enterExOpenMRS2Button));
        new Actions(driver).scrollToElement(locators.enterExOpenMRS2Button).build().perform();
        Tools.Wait(1);
        locators.enterExOpenMRS2Button.click();
        wait.until(ExpectedConditions.visibilityOf(locators.username)).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOf(locators.password)).sendKeys("Admin12");
        wait.until(ExpectedConditions.elementToBeClickable(locators.loginButton)).click();
        wait.until(ExpectedConditions.visibilityOf(locators.errorMessage));
        Assert.assertTrue(locators.errorMessage.getText().contains("You must choose a location!"),"Warning message could not be reached");
        wait.until(ExpectedConditions.elementToBeClickable(locators.InpatientWardButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locators.loginButton)).click();
        wait.until(ExpectedConditions.visibilityOf(locators.errorMessage2));
        Assert.assertTrue(locators.errorMessage2.getText().contains("Please try again"),"Warning message could not be reached");

    }














































































































}




























































