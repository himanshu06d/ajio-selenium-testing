import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchArticle {

	public static void main(String[] args) throws InterruptedException {  
		
		System.setProperty("webdriver.chrome.driver",   "E:\\\\6th SEMESTER\\\\Test Automation\\\\Lab Work\\\\Softwares\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize(); 
		driver.get("https://www.ajio.com");
	  
	  
		WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[3]/div[2]/form/div/div/input"));
		search.sendKeys("NIKE Revolution 5 Lace-Up Sports Shoes");
	  
		WebElement searchbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[3]/div[2]/form/div/button/span"));
		searchbutton.click();
	
		WebElement name = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/div/div[2]/div[2]"));
		boolean nameVisible = name.isDisplayed();
		System.out.println(nameVisible);
		  
		WebElement image = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/div/div[1]/img"));
		boolean imageVisible = image.isDisplayed();
		System.out.println(imageVisible);
		  
		WebElement price = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/div/div[2]/div[3]/span"));
		boolean priceVisible = price.isDisplayed();
		System.out.println(priceVisible);
	}  
}