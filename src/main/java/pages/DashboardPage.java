package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	By dashboardPageLogo = By.xpath("//*[@id=\"branding\"]/a[1]/img");
	By landingPageLogo = By.xpath("//*[@id=\"divLogo\"]/img");
	By usernameField = By.id("txtUsername");
	By passwordField = By.id("txtPassword");
	By signInButton = By.id("btnLogin");
	
	By userProfile = By.xpath("//*[@id=\"welcome\"]");
	By userProfileDropdown = By.xpath("//*[@id=\"welcome-menu\"]");
	By userProfileDropdownResult = By.xpath("//*[@id=\"welcome-menu\"]/ul/li");
	By logoutButton = By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean getLandingPageLogo() {
		 return driver.findElement(landingPageLogo).isDisplayed();
	}
	
	public boolean getDashboardLogo() {
		 return driver.findElement(dashboardPageLogo).isDisplayed();
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
	
	public boolean verifyDashboardPage() {
		wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
		return this.getDashboardLogo();
	}
	
	public void clickOnUserProfile() {
		driver.findElement(userProfile).click();
	}
	
	public List<WebElement> userProfileDropdownResults(){
		return driver.findElement(userProfileDropdown).findElements(userProfileDropdownResult);
	}
	
	public void clickLogout() {
		driver.findElement(logoutButton).click();
	}
	
	public boolean verifyLogoutPage() {
		wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/index.php/auth/login"));
		return this.getLandingPageLogo();
	}
	
	
}
