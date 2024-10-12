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
        US_Elements locators = new US_Elements();
        Random random = new Random();

        int randomChoosing = random.nextInt(locators.productListChooseLocation.size());
        System.out.println("Rastgele Seçim: " + randomChoosing);

        WebElement selectedLocation = locators.productListChooseLocation.get(randomChoosing);

        System.out.println("Seçilen Lokasyon: " + selectedLocation.getText());
        selectedLocation.click();


        locators.userName.sendKeys("admin");
        locators.password.sendKeys("Admin123");
        locators.lgnBttn.click();
        locators.registerBttn.click();
        locators.givenName.sendKeys("Buse Test User 6");
        locators.familyName.sendKeys("Ozer");
        locators.nextBttn.click();
        locators.genderChoosing.click();
        locators.nextBttn.click();
        locators.birthDay.sendKeys("27");

        Select months = new Select(locators.webMonths);
        months.selectByVisibleText("May");
        locators.birthYear.sendKeys("1995");
        locators.nextBttn.click();
        locators.adress1.sendKeys("Hurriyet");
        locators.nextBttn.click();
        locators.phoneNumber.sendKeys("5523088166");
        locators.nextBttn.click();

        Select relate = new Select(locators.webRelations);
        relate.selectByVisibleText("Doctor");

        locators.personName.sendKeys("Test User");
        locators.nextBttn.click();
        locators.submit.click();

        String actualName = locators.nameOnPage.getText();
        System.out.println(actualName.contains("Buse"));

        String actualID = locators.idOnPage.getText();
        System.out.println(actualID.contains("100H"));
    }

    @Test (priority = 6)
    public void SearchFromPatientList(){
        US_Elements locators = new US_Elements();



        locators.userName.sendKeys("admin");
        locators.password.sendKeys("Admin123");
        locators.location.click();
        locators.lgnBttn.click();
        locators.recordPatient.click();
        System.out.println(driver.getTitle().equals("Find Patient Record"));
        locators.searchPatient.sendKeys("anisa");
        locators.findRecord.click();
        driver.navigate().back();
        locators.searchPatient.sendKeys("Buse");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()=\"No matching records found\"]")).getText(),
                "No matching records found",
                "Metin eşleşmedi!");
    }














































































































}




























































