package OpenMRS;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class US_Elements {

      public WebDriverWait wait=new WebDriverWait(BaseDriver.driver, Duration.ofSeconds(5));
      public US_Elements() {
            PageFactory.initElements(BaseDriver.driver, this);
      }

      @FindBy(xpath = " //div[@class='gt-current-lang']")
      public WebElement languageOption;

      @FindBy(xpath = "//a[@data-gt-lang='en']")
      public WebElement choosingLanguage;

      @FindBy(xpath = "//a[@class='zak-button']")
      public  WebElement demoButton;

      @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
      public WebElement exOpenMRS2Button;

      @FindBy(xpath = "(//span[@class='elementor-button-text'])[4]")
      public WebElement enterExOpenMRS2Button;

      @FindBy(css = "[id='username']")
      public WebElement username;

      @FindBy(css = "[id='password']" )
      public WebElement password;

      @FindBy(css = "[id='loginButton']")
      public WebElement loginButton;

      @FindBy(css = "[id='sessionLocationError']")
      public WebElement errorMessage;

      @FindBy(css = "[id='Inpatient Ward']")
      public WebElement InpatientWardButton;

      @FindBy(css = "[id ='error-message']")
      public WebElement errorMessage2;

      @FindBy(xpath = "//i[@class='icon-search']")
      public WebElement findPatientRecordButton;

      @FindBy(css = "[id='appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension']")
      public WebElement appSchedulingButton;

      @FindBy(css = "[id='appointmentschedulingui-manageAppointments-app']")
      public WebElement appManageButton;

      @FindBy(css = "[id='patient-search']")
      public WebElement searchBox;

      @FindBy(xpath = "//*[text()='Buse Test User 1 Ozer']")
      public WebElement enterName;

      @FindBy(xpath = "//*[@id='patient-search-results-table']/tbody")
      public List<WebElement> locator;

      @FindBy(xpath = "(//div[@class='text'])[3]")
      public WebElement errorMessage3;

      @FindBy(xpath = "//*[@id='patient-search-results-table_info']")
      public WebElement patientcountinfo;

      @FindBy(css = "[role='alert']>tr")
      public List<WebElement> rowcounts;

      @FindBy(xpath = "//*[@id=\"sessionLocation\"]")
      public List<WebElement> productListChooseLocation;

      @FindBy(id = "username")
      public WebElement userName;

      @FindBy(id = "loginButton")
      public WebElement lgnBttn;

      @FindBy(linkText = "Register a patient")
      public WebElement registerBttn;

      @FindBy(name = "givenName")
      public WebElement givenName;

      @FindBy(name = "familyName")
      public WebElement familyName;

      @FindBy(id = "next-button")
      public WebElement nextBttn;

      @FindBy(xpath = "//option[@value=\"F\"]")
      public WebElement genderChoosing;

      @FindBy(id= "birthdateDay-field")
      public WebElement birthDay;

      @FindBy(id= "birthdateMonth-field")
      public WebElement webMonths;

      @FindBy(name= "birthdateYear")
      public WebElement birthYear;

      @FindBy(id= "address1")
      public WebElement adress1 ;

      @FindBy(name= "phoneNumber")
      public WebElement phoneNumber ;

      @FindBy(id= "relationship_type")
      public WebElement webRelations ;

      @FindBy(xpath= "//*[@id=\\\"relationship\\\"]/p[2]/input[1]")
      public WebElement personName;

      @FindBy(id= "submit")
      public WebElement submit;

      @FindBy(xpath= "//*[@id=\"content\"]/div[6]/div[1]/div/div[1]/h1/span[1]/span")
      public WebElement nameOnPage;

      @FindBy(xpath= "//*[@id=\"content\"]/div[6]/div[2]/div")
      public WebElement idOnPage;

      @FindBy(xpath= "//*[@id=\"Pharmacy\"]")
      public WebElement location;

      @FindBy(xpath= "//*[@id=\"coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension\"]")
      public WebElement recordPatient;

      @FindBy(xpath= "//input[@id=\"patient-search\"]")
      public WebElement searchPatient;

      @FindBy(xpath= "//*[@id=\"patient-search-results-table\"]/tbody")
      public WebElement findRecord;



      @FindBy(css = "[class='gt_float_switcher-arrow']")
      public WebElement languageClick;
      @FindBy(css = "[data-gt-lang='en']")
      public WebElement languageSelection;

      @FindBy(css = "[class='zak-button']")
      public WebElement demoClick;

      @FindBy(linkText = "Explore OpenMRS 2")
      public WebElement exploreOpenMRS2Click;

      @FindBy(linkText = "Enter the OpenMRS 2 Demo")
      public WebElement enterOpenMRS2Demo;


      @FindBy(id = "Inpatient Ward")
      public WebElement locationInpatientWard;

      @FindBy(id = "selected-location")
      public WebElement locationText;

      @FindBy(css = "[class='icon-signout small']")
      public WebElement logout;

      @FindBy(css = "[class='w-auto']")
      public WebElement loginText;

      @FindBy(css = "[class='nav-item identifier']")
      public WebElement adminIcon;

      @FindBy(xpath = "(//li/a)[1]")
      public WebElement myAccountClick;

      @FindBy(xpath = "(//div[@class='task'])[1]")
      public WebElement changePassword;

      @FindBy(xpath = "(//div[@class='task'])[2]")
      public WebElement myLanguages;

      @FindBy(css = "[class='icon-search']")
      public WebElement findPalientRecord;

      @FindBy(css = "[class='icon-hdd']")
      public WebElement dataManagement;

      @FindBy(css = "[class='icon-group']")
      public WebElement mergePatientElectronicRecords;

      @FindBy(css = "[id='patient1-text']")
      public WebElement PatientID1;

      @FindBy(css = "[id='patient2-text']")
      public WebElement PatientID2;

      @FindBy(css = "[id='confirm-button']")
      public WebElement continueBtn;

      @FindBy(xpath = "(//div[@class='row name'])[2]")
      public WebElement selectThePreferredRecord;

      @FindBy(xpath = "//div//h1")
      public WebElement mergingMassage;

      @FindBy(css = "[class='float-sm-right'] :nth-child(2)")
      public WebElement patientID1Text;

      @FindBy(css = "[class='float-sm-right'] :nth-child(3)")
      public WebElement patientID2Text;
      public void verifyContainsText(WebElement element, String value){


            wait.until(ExpectedConditions.textToBePresentInElement(element,value));

            Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));


      }

}


