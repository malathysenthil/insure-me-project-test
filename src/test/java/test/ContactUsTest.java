package test;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ContactUsTest {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("http://35.174.11.7:8081/index.html");
		driver.findElement(By.xpath("//*[text()='Contact Us']")).click();
		driver.findElement(By.id("inputName")).sendKeys("Malathy");
		driver.findElement(By.id("inputNumber")).sendKeys("1111111111");
		driver.findElement(By.id("inputMail")).sendKeys("abcc@xyz.com");
		driver.findElement(By.id("inputMessage")).sendKeys("Sample Test");
		driver.findElement(By.xpath("//button[@id='my-button']")).click();
		Thread.sleep(6000);
		String msg = driver.findElement(By.id("response")).getText();
		Assert.assertTrue(msg.equals("Message Sent"));  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions(); 
//		options.setHeadless(true);
//		options.addArguments("--headless");
		driver = new ChromeDriver(options);
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
