package co.Roko.selenium.webdriver.basic;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class launchbrowser {
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//open the web app
		driver.navigate().to("https://www.amazon.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Amazon.com. Spend less. Smile more."))
			System.out.println("Title matches");
		else
			System.out.println(title);
		
		//locate a web element
		String tagname = " ";
		tagname = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)")).getText();
		System.out.println(tagname);
		
		//dropdown
		WebElement category = driver.findElement(By.cssSelector("#nav-link-accountList > span"));
		Actions action = new Actions(driver);
		action.moveToElement(category).perform();
		Thread.sleep(2000);
		
		//Account
		WebElement account = driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(2)"));
		action.moveToElement(account);
		action.click();
		action.perform();
		Thread.sleep(2000);
		
		WebElement yourOrders = driver.findElement(By.cssSelector("#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1) > a > div"));
		action.moveToElement(yourOrders);
		action.click();
		action.perform();
		Thread.sleep(2000);
		
		WebElement logo = driver.findElement(By.cssSelector("#a-page > div.a-section.a-padding-medium.auth-workflow > div.a-section.a-spacing-none.auth-navbar > div > a"));
		action.moveToElement(logo);
		action.click();
		action.perform();
		Thread.sleep(2000);
		
		//Text typing
		WebElement myElement = driver.findElement(By.id("twotabsearchtextbox"));
		myElement.sendKeys("Jordan Peterson");
		
		driver.findElement(By.className("nav-right")).click();
		Thread.sleep(2000);
		
		//Select the book 
		driver.findElement(By.partialLinkText("12 Rules for Life: An Antidote to Chaos")).click();
		Thread.sleep(2000);
		
		//Shitft the tab control
		Set<String> handles = driver.getWindowHandles();
		String winHandle1 = driver.getWindowHandle();
		handles.remove(winHandle1);
		
		String winHandle = handles.iterator().next();
		String winHandle2 = " ";
		if(winHandle != winHandle1) {
			winHandle2 = winHandle; //Storing hanlde of second window handle
			//Switch control to new tab
			driver.switchTo().window(winHandle2);
			System.out.println(winHandle2);
		}
		Thread.sleep(2000);
		
		//scroll the web page till the end
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight");
		Thread.sleep(3000);
	}

}
