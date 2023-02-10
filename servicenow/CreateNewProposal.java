package servicenow;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewProposal extends ServicenowApplication {
@Test
	public  void runnewproposal() throws IOException {
		
		
		/*
		 * Asssignment 2:Create new Proposal "1. Launch ServiceNow application 2. Login
		 * with valid credential 3. Click All and Enter Proposal in filter navigator and
		 * press enter 4. Click- new and fill mandatory fields and click 'Submit'
		 * Button. 5. Verify the successful creation of new Proposal"
		 */		
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
	     shadow.findElementByXPath("//input[@id='filter']").sendKeys("Proposal");
	    shadow.findElementByXPath("//span[text()='My ']//mark").click();
	   
	    WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
	    
	    driver.switchTo().frame(frame);
	    shadow.findElementByXPath("//button[@id='sysverb_new']").click();
	    driver.findElement(By.xpath("//input[@id='std_change_proposal.number']")).click();
	     
	    driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("Great Job");
	    shadow.findElementByXPath("//button[text()='Submit']").click();
	    String text = driver.findElement(By.xpath("//td[text()='Great Job']")).getText();
	    System.out.println(text);
	}	
}
