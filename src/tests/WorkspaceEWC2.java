package tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkspaceEWC2 {
	// Variable
	WebDriver driver;
	ArrayList<String> windows;
	List<String> winLists;
	Set<String> winset;
	String wsURL = "https://google.com";
	String webchatURL = "https://www.youtube.com/?gl=VN";
	String checkLink = "https://mcha576.aoc.com:8445/CustomerControllerWeb/currentqueue";// "https://autosrv98:8445/CustomerControllerWeb/callback";
	String username = "aoc\\nvhuy0002"; // "ACC_Huy@automation";
	String password = "1_Abc_123";
	String skillset = "WC_Webchat2";// "WC_HUY_1";
	String customerEmail = "huy@gmail.com";

	@Test
	public void EWC() throws InterruptedException {
		// Thong so test
		WebDriverWait waits = new WebDriverWait(driver, 60);
		windows = new ArrayList<String>(driver.getWindowHandles());
		winLists = new ArrayList<String>(driver.getWindowHandles());
		winset = driver.getWindowHandles();
		System.out.println("winset: " + winset);
		System.out.println("windows: " + windows);
		System.out.println("winLists: " + winLists);
		openAndSwitchNewTabs(wsURL);
		openAndSwitchNewTabs(webchatURL);
		winLists = new ArrayList<String>(driver.getWindowHandles());
		winset = driver.getWindowHandles();
		System.out.println("winset: " + winset);
		System.out.println("windows: " + windows);
		System.out.println("winLists: " + winLists);
		

	}

	@BeforeMethod
	public void Setup() {
		driver = utilities.DriverFactory.CreateDriver("chrome");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(webchatURL);
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}

	public static void Hover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void openAndSwitchNewTabs(String URL) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		windows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("openAndSwitchNewTabs + Windows Array: "+windows);
		Iterator<String> itr = windows.iterator();
		System.out.println("openAndSwitchNewTabs + itr: "+itr);
		String currWindow = driver.getWindowHandle();
		System.out.println("openAndSwitchNewTabs + currWindow: "+currWindow);
		while (itr.hasNext()) {
			String window = itr.next();
			if (window.equalsIgnoreCase(currWindow)) {
				window = itr.next();
				driver.switchTo().window(window);
				driver.get(URL);
				break;
			}
		}
	}

	public void EWCpage(String URL, String linkCheck, String skillset) {
		
	}

}
