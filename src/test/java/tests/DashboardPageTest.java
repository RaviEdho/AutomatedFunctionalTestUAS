package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import pages.BasePage;
import pages.DashboardPage;
import pages.HomePage;

public class DashboardPageTest extends BasePage{
	
	@Test(priority=0)
	@Parameters({"username", "password"})
	public void navigateToDashboardPage(String username, String password) { 
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.typeUsername(username);
		logger.log(LogStatus.INFO, "Entering login username");
		dashboard.typePassword(password);
		logger.log(LogStatus.INFO, "Entering login password");
		dashboard.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Login button");
		Assert.assertTrue(dashboard.verifyDashboardPage());
		logger.log(LogStatus.PASS, "Successfully entering dashboard page");
	}
	
	@Test(priority=1)
	public void verifyUserDropdown() {
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickOnUserProfile();
		logger.log(LogStatus.INFO, "Hovering over User Profile tab");
		for(int i=0; i<dashboard.userProfileDropdownResults().size(); i++) {
			String displayedName = dashboard.userProfileDropdownResults().get(i).getText();
			System.out.print(displayedName);
			String[] expected = {
					"About", 
					"Support", 
					"Logout"};
			logger.log(LogStatus.INFO, "Checking if " + displayedName + " link is present");
			Assert.assertEquals(expected[i], displayedName);
		}
	}
	
	@Test(priority=2)
	public void verifyLogout() {
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.clickLogout();
		logger.log(LogStatus.INFO, "Clicking logout button");
		Assert.assertTrue(dashboard.verifyLogoutPage());
		logger.log(LogStatus.PASS, "Successfully logout to main page");
	}
}
	
