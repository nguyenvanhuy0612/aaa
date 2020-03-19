package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	@Test
	public void LoginTestPOM() {

		// 1. Initialize driver
		WebDriver driver = utilities.DriverFactory.CreateDriver("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

		// 2. Enter login information (Login Page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername("huy@gmail.com");
		loginPage.setPassword("123");
		loginPage.clickSubmit();

		// 3. Get Confirmation (Dashboard Page)
		DashboardPage dashboardPage = new DashboardPage(driver);
		String conf = dashboardPage.confirmationMessage();
		String tit = dashboardPage.titlePage();

		// 4. Assertions
		Assert.assertTrue(conf.contains("successfully"));
		Assert.assertTrue(tit.contains("Account"));

		// 5. Close the driver
		driver.quit();

	}
}
