package OpenMRS;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_Elements {

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













































}


