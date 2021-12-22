package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	By landingPageLogo = By.xpath("//*[@id=\"divLogo\"]/img");
	By loginForm = By.xpath("//*[@id=\"frmLogin\"]");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean getLogo() {
		 return driver.findElement(landingPageLogo).isDisplayed();
	}
	
	public boolean getLoginForm() {
		return driver.findElement(loginForm).isDisplayed();
	}
	
}
