import org.testng.annotations.Test;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class Login{
	@DataProvider(name="FirstDataProvider")
	public Object[][] dp() throws IOException, InterruptedException
	{
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
			
	    return data;
	}
	
	
	@Test(dataProvider = "FirstDataProvider")
	public void registerUser(String userName,String email,String ph_no, String pass, String gender) 
	{
		try 
		{
			System.setProperty("webdriver.chrome.driver","F:\\STUDY\\6th SEM\\Test Automation Softwares\\chromedriver_win32 (3)\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();  
			driver.manage().window().maximize();
			driver.navigate().to("https://www.ajio.com/");
		  
		  
			driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[1]/ul/li[1]/span")).click();
			driver.findElement(By.name("username")).sendKeys(email);
		  
			driver.findElement(By.className("login-btn")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
			Scanner sc = new Scanner(System.in);
			String y = sc.next();
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div[1]/div[1]/input")).sendKeys(y);
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[1]/ul/li[1]/div/div/div/div[2]/div/div/div[2]/form/div[2]/input")).click();
	
		}
		catch(Exception e) {}
	} 
}