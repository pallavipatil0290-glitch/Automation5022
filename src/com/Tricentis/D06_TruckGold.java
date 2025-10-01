package com.Tricentis;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D06_TruckGold {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://sampleapp.tricentis.com/101/index.php");
		driver.findElement(By.linkText("Truck")).click();
		//Enter Vehicle Data
		driver.findElement(By.id("entervehicledata")).click();
		new Select(driver.findElement(By.id("make"))).selectByValue("Honda");
		driver.findElement(By.id("engineperformance")).sendKeys("1000");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("08/10/2025");
		new Select(driver.findElement(By.id("numberofseats"))).selectByValue("2");
		new Select(driver.findElement(By.id("fuel"))).selectByValue("Diesel");
		driver.findElement(By.id("payload")).sendKeys("200");
		driver.findElement(By.id("totalweight")).sendKeys("1000");
		driver.findElement(By.id("listprice")).sendKeys("50000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("MH09 4590");
		driver.findElement(By.id("annualmileage")).sendKeys("20000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
		//Enter Insurant Data
		driver.findElement(By.id("firstname")).sendKeys("Varad");
		driver.findElement(By.id("lastname")).sendKeys("Patil");
		driver.findElement(By.id("birthdate")).sendKeys("09/23/2004");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(By.id("gendermale")));
		
		driver.findElement(By.id("streetaddress")).sendKeys("Shivnagar");
		new Select(driver.findElement(By.id("country"))).selectByValue("India");
		driver.findElement(By.id("zipcode")).sendKeys("418410");
		driver.findElement(By.id("city")).sendKeys("Karad");
		new Select(driver.findElement(By.id("occupation"))).selectByValue("Employee");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("bungeejumping")));
		//driver.findElement(By.id("other")).click();
		driver.findElement(By.id("website")).sendKeys("www.gmail.com");
		
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
		driver.findElement(By.id("startdate")).sendKeys("09/22/2025");
		
		new Select(driver.findElement(By.id("insurancesum"))).selectByValue("30000000");
		//new Select(driver.findElement(By.id("meritrating"))).selectByValue("Bonus 5");
		new Select(driver.findElement(By.id("damageinsurance"))).selectByValue("Partial Coverage");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("LegalDefenseInsurance")));
	//	new Select(driver.findElement(By.id("courtesycar"))).selectByValue("Yes");
		driver.findElement(By.id("nextselectpriceoption")).click();
		
		Thread.sleep(5000);
		String expPrice="900.00",expClaim="Submit",expDis="2",expCover="Limited",actPrice,actClaim,actDis,actCover;
		actPrice=driver.findElement(By.id("selectgold_price")).getText();
		actClaim=driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[3]")).getText();
		actDis=driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[3]")).getText();
		actCover=driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[3]")).getText();
		
		
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
		js.executeScript("arguments[0].click()", driver.findElement(By.id("selectgold")));
		driver.findElement(By.id("nextsendquote")).click();
		
		//Send Quotes
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9080786756");
		driver.findElement(By.id("username")).sendKeys("Varad");
		driver.findElement(By.id("password")).sendKeys("Varad@123");
		driver.findElement(By.id("confirmpassword")).sendKeys("Varad@123");
		driver.findElement(By.id("Comments")).sendKeys("No Comments");
		driver.findElement(By.id("sendemail")).click();
		
		//Sending email
		System.out.println(driver.findElement(By.xpath("/html/body/div[4]")).getText());
		driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
		
		driver.findElement(By.id("backmain")).click();

	}

}