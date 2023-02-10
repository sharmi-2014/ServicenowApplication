package servicenow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Knowledge extends ServicenowApplication {
	@Test
	public void runknowledge() throws InterruptedException {

		/*
		 * ChromeDriver driver = new ChromeDriver();
		 * driver.manage().window().maximize();
		 * driver.get("https://dev93191.service-now.com");
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * driver.findElement(By.id("user_name")).sendKeys("admin");
		 * driver.findElement(By.id("user_password")).sendKeys("Service@123");
		 * driver.findElement(By.id("sysverb_login")).click();
		 */
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
		shadow.findElementByXPath("//mark[@class='filter-match']").click();

		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Set<String> ITsearch = driver.getWindowHandles();
		List<String>window = new ArrayList<String>(ITsearch);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("//a[text()='IT']")).click();
		driver.switchTo().window(window.get(0));
		//driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]")).click();
		driver.switchTo().frame(frame);
	
		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']")).sendKeys("IT-java");

		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("Knowledge Details");
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();

	}
}
