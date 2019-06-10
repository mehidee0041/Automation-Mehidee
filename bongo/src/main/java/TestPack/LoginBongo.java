package TestPack;


	import java.io.IOException;
import java.sql.DriverManager;
import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;



	public class LoginBongo {
		
		static WebDriver driver;
	   
	    private static ut sms;
		 
		public final static String fromPhoneNumber = "+16093852858"; //this is the number your application uses
	
		
		public static void main(String[] args) throws InterruptedException, IOException {
			
	        System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-3.6.0\\chromedriver\\chromedriver.exe");
	        //driver = DriverManager.getDrivers();
	        sms = new ut();
	    	 driver = new ChromeDriver();
	         driver.get("https://www.bongobd.com/"); 
	         //driver.manage().window().maximize();
	         String currentWindow = driver.getWindowHandle();
	       
	         driver.findElement(By.xpath("//div[4]/ul/li/a")).click();
	         driver.findElement(By.id("regNext")).click();
	   
	      
	      
	         for(String winHandle : driver.getWindowHandles()){
	        	 if (winHandle != window(currentWindow)){
	        		 System.out.println(currentWindow);
	             driver.switchTo().window(winHandle);         
	           //  driver.manage().window().maximize();
	 
	        	}
	             
	          }
	         Thread.sleep(5000);

	         WebElement dp=driver.findElement(By.xpath("//*[@id=\"u_0_3\"]/div/div"));   
	         dp.click();
	         List<WebElement> allElements = driver.findElements(By.xpath("//ul[@class='_2njr']//li")); 
	         int s=allElements.size();
	         driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div/div[2]/ul/li[226]/div[1]")).click();

	 		WebElement  objPh=driver.findElement(By.name("phone_number"));
	     
	       String phoneNumber = sms.getNumber();
	       System.out.println(phoneNumber);
	      
	        objPh.click();
	   
	        //String number="6093852858";
	         objPh.sendKeys(phoneNumber);
	       
	         objPh.submit();

	       //get SMS
	         String code = sms.getMessage(phoneNumber, fromPhoneNumber);
	         System.out.println(code);
	         WebElement  objconfirmation=driver.findElement(By.name("confirmation_code"));
	         objconfirmation.click();
	      
	  
	         objconfirmation.sendKeys(code);
	            driver.close();
	             
	             }

		    private static String window(String currentWindow) {
			// TODO Auto-generated method stub
			 return null;
		}


		
		
		
		

		   
	  
	        
	      
	         


}
