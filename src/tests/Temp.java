package tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Temp {
	WebDriver driver;
	String city = "New York, New York";
	String checkIn = "03/10/2020";
	String checkOut = "03/17/2020";
	int adults = 3;
	String starInput = "star-3";
	String searchInput = "2";
	String url = "file:///C:/Users/NguyenVanHuy/Desktop/Ace%20Player%20HD%202%20(portable)/KickassTorrent%20-%20Download%20Torrents%20From%20Kickass%20Torrent.html";

	@Test
	public void Temp() throws InterruptedException {
		ArrayList<String> windows;
		WebElement browse = driver.findElement(By.xpath("//*[@id='navigation']/li[1]/a"));
		Hover(driver, browse);
		Thread.sleep(500);
		WebElement drp = driver.findElement(By.xpath("//*[@id='navigation']/li[1]/ul"));
		System.out.println(drp.findElement(By.xpath("//a[1]")));
		System.out.println(link(drp));
		
	}
	@BeforeMethod
	public void setUp() {
		// String url =
		// "https://www.expedia.com/Hotel-Search?adults=1&destination=New%20York%2C%20New%20York&endDate=2020-03-20&latLong=40.75668%2C-73.98647&regionId=178293&rooms=1&semdtl=&sort=RECOMMENDED&startDate=2020-03-10&theme=&useRewards=true&userIntent";
		driver = utilities.DriverFactory.CreateDriver("chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void closeAdsWindows() {
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				System.out.println(driver.getTitle());
				// Closing the Child Window.
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
	}

	public static void Hover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public String link(WebElement link) {
		link.findElement(By.xpath("//a[1]")).click();
		return "Done";
	}
}
