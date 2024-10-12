package OpenMRS;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @Test ( priority = 2)
    public void Login() {
        driver.get("https://openmrs.org/");
        Tools.Bekle(2);
        WebElement demo1= driver.findElement(By.xpath("//a[@class='zak-button']"));
        demo1.click();
        Tools.Bekle(2);

        WebElement demo2= driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[2]"));
        demo2.click();

        WebElement demo3= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='elementor-button-text'])[4]")));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", demo3);

        WebElement email=driver.findElement(By.id("username"));
        email.sendKeys("admin");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement ward=driver.findElement(By.id("Inpatient Ward"));
        ward.click();

        WebElement login=driver.findElement(By.cssSelector("input[id=\"loginButton\"]"));
        login.click();
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

    @Test(priority = 7)
    public void deletePatient() {

        WebElement findPatientBtn = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        findPatientBtn.click();

        WebElement searchBox = driver.findElement(By.id("patient-search"));
        searchBox.sendKeys("Tri A A");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//tr[@class='odd'])[1]")));
        WebElement chosee = driver.findElement(By.xpath("(//tr[@class='odd'])[1]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",chosee);

        WebElement deletePatientLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Patient")));
        deletePatientLink.click();

        WebElement reasonInput = driver.findElement(By.id("delete-reason"));
        reasonInput.sendKeys("keyfi");
        WebElement confirmDeleteBtn = driver.findElement(By.xpath("//button[text()='Confirm']"));
        confirmDeleteBtn.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Patient has been deleted')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Hasta silme işlemi başarısız.");
    }


    @Test(priority = 3)
    public void SistemdenCikisLogoutYapmak(){

        US_Elements locators = new US_Elements();

        driver.get("https://openmrs.org/");

        wait.until(ExpectedConditions.elementToBeClickable(locators.languageClick)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.languageSelection)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.demoClick)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.exploreOpenMRS2Click)).click();


        wait.until(ExpectedConditions.elementToBeClickable(locators.enterOpenMRS2Demo));
        js.executeScript("arguments[0].click()",locators.enterOpenMRS2Demo);

        wait.until(ExpectedConditions.elementToBeClickable(locators.userName)).sendKeys("admin");

        wait.until(ExpectedConditions.elementToBeClickable(locators.password)).sendKeys("Admin123");

        wait.until(ExpectedConditions.elementToBeClickable(locators.locationInpatientWard)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.loginButton)).click();


        locators.verifyContainsText(locators.locationText,"Inpatient Ward");

        wait.until(ExpectedConditions.elementToBeClickable(locators.logout)).click();

        System.out.println(locators.loginText.getText());

        locators.verifyContainsText(locators.loginText, "LOGIN");



    }

    @Test(priority = 5)
    public void MyAccount(){
        US_Elements locators = new US_Elements();
        driver.get("https://openmrs.org/");

        wait.until(ExpectedConditions.elementToBeClickable(locators.languageClick)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.languageSelection)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.demoClick)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.exploreOpenMRS2Click)).click();


        wait.until(ExpectedConditions.elementToBeClickable(locators.enterOpenMRS2Demo));
        js.executeScript("arguments[0].click()",locators.enterOpenMRS2Demo);

        wait.until(ExpectedConditions.elementToBeClickable(locators.userName)).sendKeys("admin");

        wait.until(ExpectedConditions.elementToBeClickable(locators.password)).sendKeys("Admin123");

        wait.until(ExpectedConditions.elementToBeClickable(locators.locationInpatientWard)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.loginButton)).click();

        locators.verifyContainsText(locators.locationText,"Inpatient Ward");

        wait.until(ExpectedConditions.visibilityOf(locators.adminIcon));
        new Actions(driver).moveToElement(locators.adminIcon).perform();
        wait.until(ExpectedConditions.elementToBeClickable(locators.myAccountClick)).click();

        locators.verifyContainsText(locators.changePassword,"Change Password");
        locators.verifyContainsText(locators.myLanguages,"My Languages");

    }

    @Test(priority = 9)
    public void HastaKayitlariniBirlestirme(){

        US_Elements locators = new US_Elements();
        driver.get("https://openmrs.org/");

        wait.until(ExpectedConditions.elementToBeClickable(locators.languageClick)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.languageSelection)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.demoClick)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.exploreOpenMRS2Click)).click();


        wait.until(ExpectedConditions.elementToBeClickable(locators.enterOpenMRS2Demo));
        js.executeScript("arguments[0].click()",locators.enterOpenMRS2Demo);

        wait.until(ExpectedConditions.elementToBeClickable(locators.userName)).sendKeys("admin");

        wait.until(ExpectedConditions.elementToBeClickable(locators.password)).sendKeys("Admin123");

        wait.until(ExpectedConditions.elementToBeClickable(locators.locationInpatientWard)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.loginButton)).click();

        locators.verifyContainsText(locators.locationText,"Inpatient Ward");

        wait.until(ExpectedConditions.elementToBeClickable(locators.dataManagement)).click();

        wait.until(ExpectedConditions.elementToBeClickable(locators.mergePatientElectronicRecords)).click();

        wait.until(ExpectedConditions.visibilityOf(locators.PatientID1)).sendKeys("100J27");
        wait.until(ExpectedConditions.visibilityOf(locators.PatientID2)).sendKeys("100H"+ Keys.TAB);


        wait.until(ExpectedConditions.elementToBeClickable(locators.continueBtn)).click();

        wait.until(ExpectedConditions.visibilityOf(locators.selectThePreferredRecord)).click();

        System.out.println(locators.mergingMassage.getText());
        locators.verifyContainsText(locators.mergingMassage,"Merging cannot be undone!");

        wait.until(ExpectedConditions.elementToBeClickable(locators.continueBtn)).click();

        wait.until(ExpectedConditions.visibilityOf(locators.patientID1Text));
        wait.until(ExpectedConditions.visibilityOf(locators.patientID2Text));

        locators.verifyContainsText(locators.patientID1Text,"100J27");
        locators.verifyContainsText(locators.patientID2Text,"100H");


    }








































































































}




























































