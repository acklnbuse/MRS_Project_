package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void FirstOptions(){
        System.out.println("Baslangic islemleri yapiliyor");

        driver=new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));

        Start();
    }

    @AfterClass
    public void LastOptions(){
        System.out.println("Kapanis islemleri yapiliyor");
        driver.quit();
    }
    public void Start() {
        driver.get("https://openmrs.org/");
        Tools.Wait(2);

        WebElement demoBttn=driver.findElement(By.xpath("//a[@class=\"zak-button\"]"));
        demoBttn.click();

        WebElement enterMRSBttn=driver.findElement(By.xpath("//span[text()=\"Enter the OpenMRS 2 Demo\"]"));
        enterMRSBttn.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://demo.openmrs.org/openmrs/login.htm"), "Yanlis url acildi.");
    }
}