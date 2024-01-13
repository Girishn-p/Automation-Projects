package seleniumbasic;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendar {

public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("");

driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
while(!driver.findElement(By.cssSelector("[class='DayPicker-Caption']")).getText().contains("May"))
{
driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
}


List<WebElement> dates= driver.findElements(By.className("DayPicker-Day"));
//Grab common attribute//Put into list and iterate
int count=driver.findElements(By.className("DayPicker-Day")).size();

for(int i=0;i<count;i++)
{
String text=driver.findElements(By.className("DayPicker-Day")).get(i).getText();
if(text.equalsIgnoreCase("21"))
{
driver.findElements(By.className("DayPicker-Day")).get(i).click();
break;
}

}
}

}