package tests;

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

		// 3. Get Confirmation (Dashboard Page)
		DashboardPage dashboardPage = new DashboardPage(driver);
		
		// 4. Close the driver
		driver.quit();

	}
}
