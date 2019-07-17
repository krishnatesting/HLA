package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightSearch {
	WebDriver driver;
	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.gecko.driver","D:\\krishna\\library\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://uat.hlafly.com/");  //http://uat.hlafly.com/
	}
	
	 @Test
	 public void choose_Language() throws InterruptedException {
		  driver.findElement(By.xpath("//span[contains(text(),English)]/parent::span/parent::div/parent::a")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[@type=\"button\"]/parent::span/child::button[1]")).click(); 
	}
	 @Test
	 public void search_Oneway() throws Exception
	 {
		 driver.findElement(By.xpath("//div[@id=\"tab-oneway\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"pane-oneway\"]/form/div/div[1]/div/div/div/div/input")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id=\"pane-oneway\"]/form/div/div[1]/div/div/div/div/input")).sendKeys("Hyderabad");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id=\"pane-oneway\"]/form/div/div[2]/div/div/div/div/input")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id=\"pane-oneway\"]/form/div/div[2]/div/div/div/div/input")).sendKeys("dubai");
 
	 }

}
