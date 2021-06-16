package SeleniumExamples;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

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
		Thread.sleep(1000);
		btnLogin.click();
		
		//FindElements
		List<WebElement> firstLevelMenu = driver.findElements(By.className("firstLevelMenu"));
		System.out.println("Numero de elementos: " + firstLevelMenu.size());
		String primerMenu = firstLevelMenu.get(0).getText();
		System.out.println(primerMenu);
		String segundoMenu = firstLevelMenu.get(1).getText();
		System.out.println(segundoMenu);
		
		for(int i=0;i<firstLevelMenu.size();i++) {
			System.out.println("Los menus son: " + firstLevelMenu.get(i).getText());
		}
	}

}
