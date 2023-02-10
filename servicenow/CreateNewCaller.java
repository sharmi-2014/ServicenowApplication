package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewCaller extends ServicenowApplication {
	@Test
public  void runnewcaller() {
	

	
	/*ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://dev93191.service-now.com");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("Service@123");
	driver.findElement(By.id("sysverb_login")).click();*/
	Shadow shadow=new Shadow(driver);
     shadow.setImplicitWait(30);
     shadow.findElementByXPath("//div[text()='All']").click();
     shadow.setImplicitWait(10);
     shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
    shadow.findElementByXPath("//mark[text()='Callers']").click();
   
    WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
    
    driver.switchTo().frame(frame);
    shadow.findElementByXPath("//button[@id='sysverb_new']").click();
    driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Sharmila");
    driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Aravindhan");
    driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys("New Caller");
    driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("sarmila.eee@gmail.com");
    driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("99");
    driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("98");
    //shadow.findElementByXPath("//iframe[@title='gsft_main']");
    //driver.switchTo().frame(frame1);
  //  shadow.findElementByXPath("(//button[text()='Submit'])[1]").click();
    driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
    driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys("Sharmila");
    System.out.println(driver.getTitle());
}
}

    
    
    


