package seleniumbasic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scopeWebdriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
        WebElement coloumDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumDriver.findElements(By.tagName("a")).size());
        
        for(int i = 1;i<coloumDriver.findElements(By.tagName("a")).size();i++)
        {
        	String clickonlinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
        	coloumDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinks);
    
        }
        Set<String> links = driver.getWindowHandles();
        Iterator <String> it= links.iterator();
        		
        while(it.hasNext()) {
        	
        	driver.switchTo().window(it.next());
        	System.out.println(driver.getTitle());
        	
        	 
        }
	}
	

}
