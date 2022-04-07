import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	public static ExtentTest test;
	public static ExtentReports report;
	public static ExtentReports extent;

	@BeforeSuite
	  public void beforeSuite() {
		  report = new ExtentReports("G:\\Test report\\ExtentReportResults.html");		      
	  }
 
  @BeforeMethod
  public void beforeMethod(Method result) {
	  test = report.startTest("Ajio - " + result.getName());
	  
  }

  @AfterMethod
  public void afterMethod(Method result) {
	  report.endTest(test);
  }

  @AfterSuite
  public static void endTest()
  { 
  report.flush();
  }

}
