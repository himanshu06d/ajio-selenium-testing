import static org.testng.Assert.assertTrue;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArticlePageNavigation {
	public static void main(String args[]) {

        System.setProperty("webdriver.chrome.driver","F:\\STUDY\\6th SEM\\Test Automation Softwares\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.ajio.com");  
	    
		WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[3]/div[2]/form/div/div/input"));
		search.sendKeys("NIKE Revolution 5 Lace-Up Sports Shoes");
		  
		WebElement searchbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[3]/div[2]/form/div/button/span"));
		searchbutton.click();

		WebElement image = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/div/div[1]/img"));
		image.click();
		
		ArrayList<String> nTabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("no of Tabs " + nTabs);
		driver.switchTo().window(nTabs.get(1));
		
		//For MRP
		WebElement mrpElement = driver.findElement(By.className("prod-cp"));
		System.out.println("mrpElement is "+ mrpElement);
		String txt = mrpElement.getText();
		System.out.println("Original price is: " + txt);
		assertTrue(txt.equalsIgnoreCase("Rs. 3,695"));
		
		//For Deal Price
		WebElement rate = driver.findElement(By.className("prod-sp"));
		String disrate = rate.getText(); 
		System.out.println("Discounted price is: " + disrate);
		assertTrue(disrate.equalsIgnoreCase("Rs. 3,141"));
		
		//For Description
		WebElement about = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div[3]/div/section/h3"));
		String text = about.getText();
		System.out.println("Tag is " + text);
		assertTrue(text.equalsIgnoreCase("Product Details"));
		
		//For Add to bag button
		WebElement bagbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div[3]/div/div[9]/div[1]/div[1]/div/span[2]"));
		System.out.println("Add to bag button is "+ bagbtn);
		assertTrue(bagbtn.isEnabled());
		
		//Save to closet button
		WebElement closetbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div[3]/div/div[9]/div[2]"));
		System.out.println("Save to closet is "+ closetbtn);
		assertTrue(closetbtn.isEnabled());
		
		//For Picture
		WebElement image1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div/div[2]/div[2]/div/div[9]/div/img"));
		assertTrue(image1.isDisplayed());
		
	}
}
