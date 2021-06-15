package Selenium1506;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
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
		driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java");
	}
}