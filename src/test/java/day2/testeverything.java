package day2;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testeverything {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//*[@id='twotabsearchtextbox']")
		)).sendKeys("nike shoes");
		
		
		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//button[@id='a-autoid-4-announce']")).click();
	
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//div[@data-csa-c-action-name='addToCartSoftlinesVariant']//button[@aria-label='Add to cart'][normalize-space()='Add to cart']")
		)).click();
		


		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait2.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//a[normalize-space()='Go to Cart']")
		)).click();
		
		String actualprice= driver.findElement(By.xpath("//span[contains(@class,'sc-product-price')]")).getText();
		System.out.println(actualprice);
	
		String expectedPrice = "INR7,174.80";

		Assert.assertEquals(actualprice, expectedPrice);
		System.out.println("expected="+expectedPrice);
	
		
		
		
		
		
		
		
		

	}

}
