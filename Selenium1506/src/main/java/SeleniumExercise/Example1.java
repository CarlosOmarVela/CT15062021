package SeleniumExercise;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example1 {

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
		
		List<WebElement> firstLevelMenu = driver.findElements(By.className("firstLevelMenu"));
		firstLevelMenu.get(8).click();
		
		WebElement employeeField = driver.findElement(By.id("searchDirectory_emp_name_empName"));
		employeeField.sendKeys("Nathan");
		Select jobSelect = new Select(driver.findElement(By.id("searchDirectory_job_title")));
		jobSelect.selectByVisibleText("Sales Representative");
		Select locSelect = new Select(driver.findElement(By.id("searchDirectory_location")));
		locSelect.selectByVisibleText("    HQ - CA, USA");
		WebElement searchBtn = driver.findElement(By.id("searchBtn"));
		searchBtn.click();
		
		WebElement nameEmployee = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[2]/td[2]/ul/li[1]"));
		System.out.println("Name: " + nameEmployee.getText());

		Thread.sleep(1000);

		driver.close(); //Close the current tab
		driver.quit(); //Close all the windows
	}

}
