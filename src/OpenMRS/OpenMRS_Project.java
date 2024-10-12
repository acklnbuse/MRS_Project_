package OpenMRS;

import US_404.Elements;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

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

    @Test (priority = 4)//(dependsOnMethods = {US_402'da kullanilan method ismini yaz},alwaysRun = true) hatali olsada calismaya devam et
    public void RegisterPatient() {
        Elements element = new Elements();
        Random random = new Random();

        int randomChoosing = random.nextInt(element.productListChooseLocation.size());
        System.out.println("Rastgele Seçim: " + randomChoosing);

        WebElement selectedLocation = element.productListChooseLocation.get(randomChoosing);

        System.out.println("Seçilen Lokasyon: " + selectedLocation.getText());
        selectedLocation.click();


        element.userName.sendKeys("admin");
        element.password.sendKeys("Admin123");
        element.lgnBttn.click();
        element.registerBttn.click();
        element.givenName.sendKeys("Buse Test User 6");
        element.familyName.sendKeys("Ozer");
        element.nextBttn.click();
        element.genderChoosing.click();
        element.nextBttn.click();
        element.birthDay.sendKeys("27");

        Select months = new Select(element.webMonths);
        months.selectByVisibleText("May");
        element.birthYear.sendKeys("1995");
        element.nextBttn.click();
        element.adress1.sendKeys("Hurriyet");
        element.nextBttn.click();
        element.phoneNumber.sendKeys("5523088166");
        element.nextBttn.click();

        Select relate = new Select(element.webRelations);
        relate.selectByVisibleText("Doctor");

        element.personName.sendKeys("Test User");
        element.nextBttn.click();
        element.submit.click();

        String actualName = element.nameOnPage.getText();
        System.out.println(actualName.contains("Buse"));

        String actualID = element.idOnPage.getText();
        System.out.println(actualID.contains("100H"));
    }

    @Test (priority = 6)
    public void SearchFromPatientList(){

        Elements element = new Elements();

        element.userName.sendKeys("admin");
        element.password.sendKeys("Admin123");
        element.location.click();
        element.lgnBttn.click();
        element.recordPatient.click();
        System.out.println(driver.getTitle().equals("Find Patient Record"));
        element.searchPatient.sendKeys("anisa");
        element.findRecord.click();
        driver.navigate().back();
        element.searchPatient.sendKeys("Buse");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()=\"No matching records found\"]")).getText(),
                "No matching records found",
                "Metin eşleşmedi!");
    }














































































































}




























































