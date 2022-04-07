import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReport {
	static ExtentTest test;
	static ExtentReports report;
	String baseUrl="https://www.ajio.com";
	String driverpath="F:\\STUDY\\6th SEM\\Test Automation Softwares\\chromedriver_win32 (3)\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeClass
	public void initializeReport() {
		report= new ExtentReports("F:\\STUDY\\6th SEM\\Test Automation Softwares\\extent1.html",true);
	}
			
  @BeforeTest
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();    
		driver.get(baseUrl);
		driver.manage().window().maximize();
  }
  
  @BeforeMethod
  public static void startReport(Method result) {
	  test = report.startTest("ExtentDemo - " + result.getName());
  }
  
  @Test(priority=0)
  public void clickOnlogin() {
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/span")).click();
      test.log(LogStatus.INFO, "Starting with login");
      if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/span")) != null) {
        test.log(LogStatus.PASS, "Sign-in Button located");
      }
      else
          test.log(LogStatus.FAIL, "Sign-in button could not be located");
  }
  
//Write E-mail address or phone number in the text field
  @Test(priority=1)
  public void Number()
  {
  WebElement number = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/form/div[2]/div[1]/label/input"));
  test.log(LogStatus.INFO, "Entering number ");
  if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/form/div[2]/div[1]/label/input")) != null) {
    test.log(LogStatus.PASS, "Enter number text field located");
  }
  else
      test.log(LogStatus.FAIL, "Enter Number text field could not be located");
  number.sendKeys("7477252637");
  }
//Click on continue button
  @Test(priority=2)
  public void ContinueButton() {
  WebElement continuebutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/form/div[2]/div[2]/input"));
  test.log(LogStatus.INFO, "Continuing to Enter Password ");
  if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/form/div[2]/div[2]/input")) != null) {
    test.log(LogStatus.PASS, "Click next button located");
  }
  else
      test.log(LogStatus.FAIL, "Click next button could not be located");
  continuebutton.click();
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  // Write password in the text field
  @Test(priority=3)
  public void PassCode() {
  WebElement password = driver.findElement(By.name("otp"));
  test.log(LogStatus.INFO, "Entering Otp ");
  if(driver.findElement(By.name("otp")) != null) {
    test.log(LogStatus.PASS, "otp text field located");
  }
  else
      test.log(LogStatus.FAIL, "Password text field could not be located");
  Scanner sc1 = new Scanner(System.in);
  String xy = sc1.next();
  password.sendKeys("sy");
  }

  // Click on sign in button
  @Test(priority=4)
  public void LogIn() {
  WebElement login =driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div[3]/input"));
  test.log(LogStatus.INFO, "Clicking Logging In button ");
  if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div[3]/input")) != null) {
    test.log(LogStatus.PASS, "Log in button located");
  }
  else
      test.log(LogStatus.FAIL, "Log in button could not be located");
  login.click();
  }
  
  @AfterClass
  public static void endTest()
  {
  report.endTest(test);
  report.flush();
  }
}
