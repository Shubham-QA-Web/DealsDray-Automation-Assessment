package AutomationIntro.SeleniumProjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DealsDrayFileUpload {


public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\eclipse work\\SeleniumProjects\\Resource\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demo.dealsdray.com/");
	//Maximize Window
	driver.manage().window().maximize();
	Thread.sleep(2000);
	//UserName
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("prexo.mis@dealsdray.com");
	//PassWord
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("prexo.mis@dealsdray.com");
	//Login button 
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/button[1]")).click();
	Thread.sleep(2000);
	//Click On Hamburger Button (MIS Panel)
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
	Thread.sleep(1000);
	//Click On Order Button
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]/button[1]/span[1]")).click();
	Thread.sleep(1000);
	//Click On Add Bulk Order
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
	
	// Wait for the bulk import page to load after login
    WebDriverWait wait = new WebDriverWait(driver, 10); // Timeout in seconds

    // Wait until the file input element is visible and Interactable
    WebElement fileInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='file']")));

    // Provide the file path to upload
    fileInput.sendKeys("C:\\DealsDray Assesment Test\\demo-data.xlsx");     
    
    //click on import
    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[3]/button[1]")).click();
    
    //click on validate
    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[3]/button[1]")).click();
    
	Thread.sleep(3000);

    // Switch to the alert popup
    Alert alert = driver.switchTo().alert();

    // Accept the alert (click "OK")
    alert.accept();
    
    
    
      //Scroll Down
    
  		
  	




}
}

