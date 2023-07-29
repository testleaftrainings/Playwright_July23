package week4.day1;

import java.nio.file.Paths;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Persistent_BrowserContext {

	public static void main(String[] args) {
	
		Playwright pw = Playwright.create();
		BrowserContext context = pw.chromium().launchPersistentContext(
				Paths.get("C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Default"),
				new BrowserType.LaunchPersistentContextOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		Page page = context.newPage();

		// Load the URL
		page.navigate("");

//		// Type the username
//		// page.locator("[id='username']").type("demosalesmanager");
//		page.type("#username", "demosalesmanager");
//
//		// Type the password
//		page.locator("#password").type("crmsfa");
//		// Click Login
//		page.click(".decorativeSubmit");
	}

}
