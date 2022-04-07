import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Registration extends BaseTest{
	static WebDriver driver;
	@BeforeClass
	  public static void startTest()
	  {
		  System.setProperty("webdriver.chrome.driver","F:\\STUDY\\6th SEM\\Test Automation Softwares\\chromedriver_win32 (3)\\chromedriver.exe");
			 driver=new ChromeDriver();  
			 driver.manage().window().maximize();
			 // Launch website  
			 driver.navigate().to("https://www.ajio.com/");
		  
		  driver.manage().window().maximize();
	  }
	
	  @DataProvider(name="FirstDataProvider")
	  public Object[][] dp() throws IOException, InterruptedException{
			Object[][] data = new Object[1][5];
			int x=0;
			FileInputStream fis= new FileInputStream("F:\\STUDY\\6th SEM\\testing_selenium_1.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet login= wb.getSheet("Sheet1");
			for(int i=1;i<=login.getLastRowNum();++i) {
				XSSFRow row= login.getRow(i);
				if(row.getCell(0).getCellType()==CellType.NUMERIC) {
					data[x][0]= row.getCell(0).getRawValue();
					
				}
				else {
					data[x][0]=row.getCell(0).toString();
				}
				
				data[x][1]= row.getCell(1).toString();
				data[x][2]= row.getCell(2).getRawValue();
				data[x][3]= row.getCell(3).toString();
				data[x][4]= row.getCell(4).toString();
				
				    ++x;
			}
		  
	     
	    //return data
			
	    return data;
	}
	  @Test(dataProvider = "FirstDataProvider")
	public void registerUser(String userName,String email,String ph_no, String pass, String gender) {
		  test.log(LogStatus.INFO, "user registration");
	 try {
		 driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[1]/ul/li[1]/span")).click();
		  driver.findElement(By.name("username")).sendKeys(email);
		  driver.findElement(By.className("login-btn")).click();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  	WebElement male =    driver.findElement(By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/div/div/div[2]/form/div[3]/label[2]/span"));
			WebElement female =    driver.findElement(By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/div/div/div[2]/form/div[3]/label[1]/span"));
			
			if(gender == "F")
				female.click();
			else
				male.click();

		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div[5]/input")).sendKeys(userName);
		  
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div[7]/input")).sendKeys(ph_no);
		  driver.findElement(By.xpath("//*[@id=\"pwdInput\"]")).sendKeys(pass);
		  
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div[13]/label/input")).click();
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div[15]/input")).click();
		
		
		  Scanner sc = new Scanner(System.in);
		  String x = sc.next();
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div/div[2]/div[1]/input")).sendKeys(x);
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div/div[3]/input")).click();
		
		  test.log(LogStatus.PASS, "user login pass");
	 }catch(Exception e) {
		 test.log(LogStatus.FAIL, "registration Fail");
		 test.log(LogStatus.ERROR, e);
	 }	
   }	
}
