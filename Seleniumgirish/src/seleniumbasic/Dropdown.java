package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights/?gclid=Cj0KCQiA35urBhDCARIsAOU7Qwm9yo9Yroao7V2zfo4zfNs1MJ5iZuozs-GlSrEy2LRMg_AUDtrzrw4aAivmEALw_wcB&cmp=SEM|D|DF|G|Generic|Generic-Generic_DT|DF_Generic_Exact|RSA|Offer3|673438880768&s_kwcid=AL!1631!3!673438880768!e!!g!!flight%20booking&ef_id=Cj0KCQiA35urBhDCARIsAOU7Qwm9yo9Yroao7V2zfo4zfNs1MJ5iZuozs-GlSrEy2LRMg_AUDtrzrw4aAivmEALw_wcB:G:s&gad_source=1");
       driver.findElement(By.id("username")).sendKeys("9901451469");
       Thread.sleep(2000l);
       driver.findElement(By.className("div[class='btnContainer appendBottom25']")).click();
		
		driver.findElement(By.cssSelector("label[for='fromCity']")).click();
	}

}
