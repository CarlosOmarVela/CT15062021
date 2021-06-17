package SeleniumExamples;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitEj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		//Find the drivers path
		String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "drivers" + File.separator;
		//Identify the .exe driver
		System.setProperty("webdriver.chrome.driver", exePath + "chromedriver91.exe");
		//Creat a driver instance
		WebDriver driver = new ChromeDriver();
		//Open web page
		driver.get("https://opensource-demo.orangehrmlive.com");
		//Maxime the window
		driver.manage().window().maximize();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Get objects or Web Elements from web page
		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		
		driver.close(); //Close the current tab
		driver.quit(); //Close all the windows
	}

}
