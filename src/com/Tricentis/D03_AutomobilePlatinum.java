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

public class D03_AutomobilePlatinum {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://sampleapp.tricentis.com/101/index.php");
		driver.findElement(By.linkText("Automobile")).click();
		//Enter Vehicle Data
		driver.findElement(By.id("entervehicledata")).click();
		new Select(driver.findElement(By.id("make"))).selectByValue("Suzuki");
		driver.findElement(By.id("engineperformance")).sendKeys("2000");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("07/15/2025");
		new Select(driver.findElement(By.id("numberofseats"))).selectByValue("4");
		new Select(driver.findElement(By.id("fuel"))).selectByValue("Gas");
		driver.findElement(By.id("listprice")).sendKeys("80000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("MH142875");
		driver.findElement(By.id("annualmileage")).sendKeys("40000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
		//Enter Insurant Data
		driver.findElement(By.id("firstname")).sendKeys("Samadhan");
		driver.findElement(By.id("lastname")).sendKeys("Patil");
		driver.findElement(By.id("birthdate")).sendKeys("05/03/2000");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(By.id("gendermale")));
		
		driver.findElement(By.id("streetaddress")).sendKeys("Link road");
		new Select(driver.findElement(By.id("country"))).selectByValue("India");
		driver.findElement(By.id("zipcode")).sendKeys("414405");
		driver.findElement(By.id("city")).sendKeys("Kolhapur");
		new Select(driver.findElement(By.id("occupation"))).selectByValue("Farmer");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("skydiving")));
		//driver.findElement(By.id("other")).click();
		driver.findElement(By.id("website")).sendKeys("www.lokmat.com");
		
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
		driver.findElement(By.id("startdate")).sendKeys("09/30/2025");
		//driver.findElement(By.id("insurancesum")).sendKeys("10000000");
		new Select(driver.findElement(By.id("insurancesum"))).selectByValue("5000000");
		new Select(driver.findElement(By.id("meritrating"))).selectByValue("Bonus 4");
		new Select(driver.findElement(By.id("damageinsurance"))).selectByValue("Partial Coverage");
		js.executeScript("arguments[0].click()", driver.findElement(By.id("LegalDefenseInsurance")));
		new Select(driver.findElement(By.id("courtesycar"))).selectByValue("No");
		driver.findElement(By.id("nextselectpriceoption")).click();
		
		Thread.sleep(5000);
		String expPrice="1,767.00",expClaim="Submit",expDis="5",expCover="Limited",actPrice,actClaim,actDis,actCover;
		actPrice=driver.findElement(By.id("selectplatinum_price")).getText();
		actClaim=driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[4]")).getText();
		actDis=driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[4]")).getText();
		actCover=driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[4]")).getText();
		
		
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
		js.executeScript("arguments[0].click()", driver.findElement(By.id("selectplatinum")));
		driver.findElement(By.id("nextsendquote")).click();
		
		//Send Quotes
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9080786756");
		driver.findElement(By.id("username")).sendKeys("Samadhan");
		driver.findElement(By.id("password")).sendKeys("Samadhan@123");
		driver.findElement(By.id("confirmpassword")).sendKeys("Samadhan@123");
		driver.findElement(By.id("Comments")).sendKeys("No Comments");
		driver.findElement(By.id("sendemail")).click();
		
		//Sending email
		System.out.println(driver.findElement(By.xpath("/html/body/div[4]")).getText());
		driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
		
		driver.findElement(By.id("backmain")).click();

	}

}
