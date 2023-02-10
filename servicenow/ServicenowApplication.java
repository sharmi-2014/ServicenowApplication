package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.sukgu.Shadow;

public class ServicenowApplication {
	public ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void LaunchBrowser(String url,String uname,String pwd) {
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.id("user_name")).sendKeys(uname);
	driver.findElement(By.id("user_password")).sendKeys(pwd);
	driver.findElement(By.id("sysverb_login")).click();
	
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
