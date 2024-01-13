package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceAssingment {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
	    String opt = driver.findElement(By.cssSelector("label[for='benz']")).getText();
	   WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
        dropdown.click();
        Select s=new Select(dropdown);
	    s.selectByVisibleText(opt);
	    driver.findElement(By.name("enter-name")).sendKeys(opt);
	    driver.findElement(By.id("alertbtn")).click();
	    String text = driver.switchTo().alert().getText();
	    if(text.contains(opt))
	    {
          System.out.println("alert message success");
          
          }
	    else {
	    	System.out.println("alert message not successful");
	    	
}
	   driver.switchTo().alert().accept();
	    
}
}