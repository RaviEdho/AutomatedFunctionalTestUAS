package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	By usernameField = By.id("txtUsername");
	By passwordField = By.id("txtPassword");
	By signInButton = By.id("btnLogin");
	By errorContainer = By.xpath("//*[@id=\"spanMessage\"]");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver; 
		wait = new WebDriverWait(driver, 10);
	}
	
	public void typeUsername(String username) { //pass a parameter so we don't hardcode values in the object class.
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void typePassword(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}
	
	public boolean errorContainerDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorContainer)).isDisplayed();
	}
	
	public boolean verifyNewPage() {
		wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
		return driver.getTitle().contains("OrangeHRM");
	}

}
