package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions options= new ChromeOptions(); 
		options.addArguments("--window-size=1920,1080");
	    options.addArguments("--start-maximized");
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);

		driver.get("http://107.22.93.101:8081/index.html");
		driver.findElement(By.xpath("//*[text()='Contact Us']")).click();
		driver.findElement(By.id("inputName")).sendKeys("Malathy");
		driver.findElement(By.id("inputNumber")).sendKeys("1111111111");
		driver.findElement(By.id("inputMail")).sendKeys("abcc@xyz.com");
		driver.findElement(By.id("inputMessage")).sendKeys("Sample Test");
		driver.findElement(By.xpath("//button[@id='my-button']")).click();
		Thread.sleep(6000);
		String msg = driver.findElement(By.id("response")).getText();
		if (msg.equals("Message Sent")) {
			System.out.println("Test case Passed");
		} else {
			System.out.println("Test case Failed");
		}
		driver.close();
	}

}
