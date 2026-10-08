package javaseleniumday1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class getwindowhandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parentid=driver.getWindowHandle();
		System.out.println(parentid);
		
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'OrangeHRM')]"))).click();
		
		Set<String> allwindows=driver.getWindowHandles();
		System.out.println(allwindows);
		
		for(String childid:allwindows) {
			if(! parentid.equals(childid)) {
				driver.switchTo().window(childid);
				//driver.switchTo().window(parentid);
			}
		}
	}

}
