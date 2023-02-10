package servicenow;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OrderingMobile extends ServicenowApplication {
@Test
	public  void runorderingmobile() throws IOException {
		
	
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
     //shadow.setImplicitWait(10);
     shadow.findElementByXPath("//span[text()='Service Catalog']").click();

     WebElement findElementByXPath = shadow.findElementByXPath("//iframe[@id='gsft_main']");
     driver.switchTo().frame(findElementByXPath);
     driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
 
    driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
    driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();  
    WebElement findElement = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));

   //WebElement unlimited = driver.findElement(By.xpath("//option[text()='Unlimited']"));
   Select drop=new Select(findElement);
   drop.selectByIndex(2);
   driver.findElement(By.xpath("//label[text()='Blue']")).click();

   driver.findElement(By.xpath("//label[text()='256 GB [add $100.00]']")).click();

   driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();

   String text = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
   System.out.println(text);
   String text2 = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
   System.out.println(text2);
   File source = driver.getScreenshotAs(OutputType.FILE);
   File dest =new File("./snap/ServiceNow.png");
   FileUtils.copyFile(source, dest);

	
	}
}
