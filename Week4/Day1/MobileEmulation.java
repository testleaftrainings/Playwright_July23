package week4.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MobileEmulation {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setDeviceScaleFactor(2)
				.setHasTouch(true)
				.setIsMobile(true)
				.setViewportSize(412, 914));
		Page page = context.newPage();

		// Load the URL
		page.navigate("https://www.flipkart.com/");
		
				
	}

}
