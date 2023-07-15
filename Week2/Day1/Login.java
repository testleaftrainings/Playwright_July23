package week2.day1;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Login {

	public static void main(String[] args) {

		// Initialize Playwright
		Playwright pw = Playwright.create();

		// Launch the browser
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome").setHeadless(false));

		//BrowserContext
		BrowserContext context = browser.newContext();

		//Open a new Page
		Page page = context.newPage();

		// Load the URL
		page.navigate("http://leaftaps.com/opentaps/control/main");

		// Type the username
		// page.locator("[id='username']").type("demosalesmanager");
		page.type("#username", "demosalesmanager");
		// page.pause();
		// Type the password
		page.locator("#password").type("crmsfa");
		// Click Login
		page.click(".decorativeSubmit");
		//Store the information as json
		context.storageState(new BrowserContext.StorageStateOptions()
				.setPath(Paths.get("login_leaftaps_demo.json")));


	}

}
