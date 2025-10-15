package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SeleniumGrid.Utility.Utility;

public class ParallelTest {
	public WebDriver driver;
	@Parameters({"bname"})
  @Test
  public void crossBrowserTest(String bname) throws MalformedURLException, URISyntaxException, InterruptedException {
		URL serverUrl=new URI("http://localhost:4444/").toURL();
		System.out.println("Remote driver connectivity is started!");
	  if(bname.equals("Chrome")) {
		   ChromeOptions options=new ChromeOptions();
		   
		   driver=new RemoteWebDriver(serverUrl,options);
		   Utility.getScreenshot(driver);
		   System.out.println("Session created on chrome!");
	  }
	  else if(bname.equals("Edge")) {
		  EdgeOptions options=new EdgeOptions();
		  
		  driver=new RemoteWebDriver(serverUrl,options);
		  Utility.getScreenshot(driver);
		  System.out.println("Session created on Edge!");
	  }
	  else if(bname.equals("Firefox")) {
		  FirefoxOptions options=new FirefoxOptions();
		  
		  driver=new RemoteWebDriver(serverUrl,options);
		  Utility.getScreenshot(driver);
		  System.out.println("Session created on Firefox!");
		  
	  }
	  
	  System.out.println("Remote driver connectivity is completed!");
	  Thread.sleep(10000);
	  driver.get("https://www.amazon.in");
	  Thread.sleep(6000);
	  System.out.println("Title is: "+driver.getTitle());
	  
	  driver.quit();
  }
}
