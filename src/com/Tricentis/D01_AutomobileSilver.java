package com.Tricentis;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class D01_AutomobileSilver {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://sampleapp.tricentis.com/101/index.php");
		driver.findElement(By.linkText("Automobile")).click();
		//Enter Vehicle Data
		driver.findElement(By.id("entervehicledata")).click();
		new Select(driver.findElement(By.id("make"))).selectByValue("Skoda");
		driver.findElement(By.id("engineperformance")).sendKeys("1000");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("08/18/2025");
		new Select(driver.findElement(By.id("numberofseats"))).selectByValue("4");
		new Select(driver.findElement(By.id("fuel"))).selectByValue("Petrol");
		driver.findElement(By.id("listprice")).sendKeys("100000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("MH142473");
		driver.findElement(By.id("annualmileage")).sendKeys("10000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
		//Enter Insurant Data
		driver.findElement(By.id("firstname")).sendKeys("Pallavi");
		driver.findElement(By.id("lastname")).sendKeys("Patil");
		driver.findElement(By.id("birthdate")).sendKeys("06/02/1990");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(By.id("genderfemale")));
		
		driver.findElement(By.id("streetaddress")).sendKeys("Udyognagar");
		new Select(driver.findElement(By.id("country"))).selectByValue("India");
		driver.findElement(By.id("zipcode")).sendKeys("411033");
		driver.findElement(By.id("city")).sendKeys("Pune");
		new Select(driver.findElement(By.id("occupation"))).selectByValue("Employee");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("other")));
		//driver.findElement(By.id("other")).click();
		driver.findElement(By.id("website")).sendKeys("www.google.com");
		
        driver.findElement(By.id("open")).click();
		//Upload Picture using Robot class
		Robot rb=new Robot();
		for(int i=1;i<=8;i++) {
			
			Thread.sleep(500);
			rb.keyPress(KeyEvent.VK_TAB);
		}
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_TAB);
        for(int i=1;i<=9;i++) {
			
			Thread.sleep(500);
			rb.keyPress(KeyEvent.VK_DOWN);
		}
        Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		driver.findElement(By.id("nextenterproductdata")).click();
		//Enter Product Data
		driver.findElement(By.id("startdate")).sendKeys("09/29/2025");
		driver.findElement(By.id("insurancesum")).sendKeys("10000000");
		new Select(driver.findElement(By.id("insurancesum"))).selectByValue("10000000");
		new Select(driver.findElement(By.id("meritrating"))).selectByValue("Bonus 2");
		new Select(driver.findElement(By.id("damageinsurance"))).selectByValue("Full Coverage");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("EuroProtection")));
		new Select(driver.findElement(By.id("courtesycar"))).selectByValue("Yes");
		driver.findElement(By.id("nextselectpriceoption")).click();
		Thread.sleep(5000);
		String expPrice="305.00",expClaim="No",expDis="No",expCover="No",actPrice,actClaim,actDis,actCover;
		actPrice=driver.findElement(By.id("selectsilver_price")).getText();
		actClaim=driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[2]")).getText();
		actDis=driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[2]")).getText();
		actCover=driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[2]")).getText();
		
		
		if(actPrice.equals(expPrice))
			System.out.println("Price Matching");
		else
			System.out.println("Price not matching");
		if(actClaim.equals(expClaim))
			System.out.println("Online claim Matching");
		else
			System.out.println("Online claim not matching");
		if(actDis.equals(expDis))
			System.out.println("Claim Discount Matching");
		else
			System.out.println("Claim Discoun not matching");
		if(actCover.equals(expCover))
			System.out.println("Online cover Matching");
		else
			System.out.println("Online cover not matching");
		
		//Select price option
		js.executeScript("arguments[0].click()", driver.findElement(By.id("selectsilver")));
		driver.findElement(By.id("nextsendquote")).click();
		
		//Send Quotes
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9080786756");
		driver.findElement(By.id("username")).sendKeys("Pallavi");
		driver.findElement(By.id("password")).sendKeys("Pallavi@123");
		driver.findElement(By.id("confirmpassword")).sendKeys("Pallavi@123");
		driver.findElement(By.id("Comments")).sendKeys("No Comments");
		driver.findElement(By.id("sendemail")).click();
		
		//Sending email
		System.out.println(driver.findElement(By.xpath("/html/body/div[4]")).getText());
		driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
		
		driver.findElement(By.id("backmain")).click();
		
		
	}

}
