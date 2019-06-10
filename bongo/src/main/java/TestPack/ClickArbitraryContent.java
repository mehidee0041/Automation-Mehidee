package TestPack;

import org.openqa.selenium.WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
public class ClickArbitraryContent {
   // private static LoginBongo login;
	
	WebDriver driver;
	

public  void linksclick() throws Exception{ 

     System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-3.6.0\\chromedriver\\chromedriver.exe");
	 driver = new ChromeDriver();
    String baseUrl = "https://www.bongobd.com/";
    driver.get(baseUrl);
    
    List<WebElement> allLinks = driver.findElements(By.tagName("a"));
    System.out.println("All Links--> " + allLinks.size());
    driver.findElement(By.cssSelector("a[href*='watch']")).click();
    

   driver.close();   
}
    

public static void main(String[] args) throws Exception {

	ClickArbitraryContent obj = new ClickArbitraryContent();
	obj.linksclick();

}

}

