package Sample.TestNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {
	public static void main(String[] args){
	System.setProperty("WebDriver.chrome.Driver", "C:\\chromedriver_win32\\chromedriver.exe");
	WebDriver Driver= new ChromeDriver();
	Driver.get("https://google.com");}
	
	
	
}
