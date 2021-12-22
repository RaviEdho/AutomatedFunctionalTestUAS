package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.BasePage;
import pages.HomePage;

public class HomePageTest extends BasePage{

	@Test(priority=0)
	public void verifyTitle() {
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking title matches string");
		Assert.assertEquals(homePage.getTitle(), "OrangeHRM", "Title does not match");
		logger.log(LogStatus.PASS, "Title matches with title from DOM");
	}

	@Test(priority=1)
	public void verifyLogo() {
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking if logo is present");
		Assert.assertTrue(homePage.getLogo());
		logger.log(LogStatus.PASS, "Logo is present");
	}

	@Test(priority=2)
	public void verifyLoginForm() {
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking if login form is present");
		Assert.assertTrue(homePage.getLoginForm());
		logger.log(LogStatus.PASS, "Login form is present");
	}
}
