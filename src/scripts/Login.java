package scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class Login {
	WebDriver driver;
	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.gecko.driver","D:\\krishna\\library\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");  //http://uat.hlafly.com/
	}

	/*
	 * @Test public void choose_Language() throws InterruptedException {
	 * driver.findElement(By.xpath(
	 * "/html/body/div[1]/header/section/ul/li[4]/a/div/span/span")).click();
	 * Thread.sleep(2000);
	 * driver.findElement(By.xpath("/html/body/ul/span[2]/button[1]")).click(); }
	 */
	@Test
	public void login() throws Exception {
		FileInputStream fi=new FileInputStream
				  ("C:\\Users\\Sravan\\Desktop\\HLAFLY.xls");
				  Workbook wb=Workbook.getWorkbook(fi); 
				  Sheet s=wb.getSheet("TESTDATA"); 
				  System.out.println(s.getRows());
		//driver.findElement(By.xpath("//*[@id=\"app\"]/header/section/ul/li[2]/div/a")).click();
	
		for(int r=1;r<s.getRows();r++) {
			driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();////input[@placeholder=\"Enter Email Id\"]
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type=\"password\" and @ name=\"pass\"]")).clear();////input[@type=\"password\"][@placeholder=\"Enter Password\"]
			Thread.sleep(2000);
			
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(s.getCell(0, r).getContents());
		System.out.println(s.getCell(0, r).getContents());
		
		driver.findElement(By.xpath("//input[@type=\"password\" and @ name=\"pass\"]")).sendKeys(s.getCell(1, r).getContents());
		System.out.println(s.getCell(1, r).getContents());
		
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();////*[@id=\"pane-signin\"]/form/div[4]/div/button
		
					

		}
	}
	

}
