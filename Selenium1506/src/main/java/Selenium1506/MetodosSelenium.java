package Selenium1506;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MetodosSelenium {

	public static void main(String[] args) throws InterruptedException {
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
		
		//Get objects or Web Elements from web page
		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		btnLogin.click();
		Thread.sleep(2000);
		
		//Explore Method
		String title = driver.getTitle();
		System.out.println("El título es: " + title);
		
		//Validate homepage
		String urlDashboard = driver.getCurrentUrl();
		System.out.println("Current URL is: " + urlDashboard);
		boolean loginCorrect = urlDashboard.contains("/dashboard");//return boolean
		if(loginCorrect) {
			System.out.println("Login correcto");
		}else {
			System.out.println("Login incorrecto");
		}
		
		//Navigation method
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		driver.close(); //Close the current tab
		driver.quit(); //Close all the windows
	}

}
