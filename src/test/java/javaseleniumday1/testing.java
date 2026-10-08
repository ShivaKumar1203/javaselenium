package javaseleniumday1;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testing {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.com/ref=nav_logo");
//	driver.switchTo().newWindow(WindowType.TAB);
	//File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']"))).sendKeys("shoes");
   

   WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
   wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='nav-search-submit-button']"))).click();
   
   WebDriverWait wait11 = new WebDriverWait(driver,Duration.ofSeconds(10));
   wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='Add to cart'])[4]"))).click();
  
   WebDriverWait wait111 = new WebDriverWait(driver,Duration.ofSeconds(10));
   wait111.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-row puis-atc-variation-element puis-atc-variation-element-B07NJNRHJR puis-atc-variation-element-selected']//button[@aria-label='Add to cart'][normalize-space()='Add to cart']"))).click();

  WebDriverWait wait1111 = new WebDriverWait(driver,Duration.ofSeconds(10));
   wait1111.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-row puis-atc-variation-element puis-atc-variation-element-B0DQYG9CSN puis-atc-variation-element-selected']//div[@data-csa-c-type='action']"))).click();
  
	}

}
