package week4.day2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass {

	public Playwright pw;
	public Browser browser;
	public Page page;
	private static String browserName;
	
	@BeforeMethod
	public void setup() {

		pw = Playwright.create();
		if(getBrowserName()== null) {
			setBrowserName("chrome");
		}
		System.out.println(getBrowserName());	
		// Launch the browser
		browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel(getBrowserName()).setHeadless(false));

		// Open a new page
		page = browser.newPage();

		// Load the URL
		page.navigate("http://leaftaps.com/opentaps/control/main");

		// Type the username
		// page.locator("[id='username']").type("demosalesmanager");
		page.type("#username", "demosalesmanager");

		// Type the password
		page.locator("#password").type("crmsfa");
		// Click Login
		page.click(".decorativeSubmit");
		// Click CRM/SFA

		page.click("text=CRM/SFA");
		// Click Leads
		page.click("text=Leads");
	}

	@AfterMethod
	public void tearDown() {

		pw.close();

	}

	public static String getBrowserName() {
		return browserName;
	}

	public static void setBrowserName(String browserName) {
		BaseClass.browserName = browserName;
	}

}
