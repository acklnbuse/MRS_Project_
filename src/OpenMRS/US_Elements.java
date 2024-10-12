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













































}


