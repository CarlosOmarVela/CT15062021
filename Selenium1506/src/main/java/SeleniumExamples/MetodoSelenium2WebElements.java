package SeleniumExamples;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MetodoSelenium2WebElements {
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
				
				//Click on button Assign leave
				WebElement assignLeave = driver.findElement(By.className("quickLinkText"));
				Thread.sleep(1000);
				assignLeave.click();
				
				//fill textbox
				WebElement employeeName = driver.findElement(By.name("assignleave[txtEmployee][empName]"));
				employeeName.sendKeys("Carlos Omar Vela");
				
				//Verify element displayed
				boolean assignBtn = driver.findElement(By.id("assignBtn")).isDisplayed();
				if(assignBtn) {
					System.out.println("El botón assign esta desplegado");
				}
				
				//Obtain text from webElement
				String welcomeMsg = driver.findElement(By.id("welcome")).getText();
				System.out.println("Welcome messaje: " + welcomeMsg);
				boolean userMsj = welcomeMsg.contains("Paul");
				if(assignBtn) {
					System.out.println("El Mensaje contiene Paul");
				}
				
				//Interact with dropdown
				Select oSelect = new Select(driver.findElement(By.id("assignleave_txtLeaveType")));
				oSelect.selectByIndex(1);
				//oSelect.selectByVisibleText("US - FMLA");
				Thread.sleep(1000);

				driver.close(); //Close the current tab
				driver.quit(); //Close all the windows
	}
}
