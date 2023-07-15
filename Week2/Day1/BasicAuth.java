package week2.day1;

import com.microsoft.playwright.Browser;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BasicAuth {


	public static void main(String[] args) {
		// Initialize Playwright
		Playwright pw = Playwright.create();

		// Launch the browser
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome").setHeadless(false));
		
		//BrowserContext
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setHttpCredentials("admin", "testleaf"));
		/*
		 * Page page1 = context1.newPage(); 
		 * page1.navigate("https://www.amazon.in/");
		 * 
		 * BrowserContext context2 = browser.newContext(); 
		 * Page page2 = context2.newPage(); 
		 * page2.navigate("https://leafground.com/auth.xhtml");
		 */
		Page page = context.newPage();
		page.navigate("https://leafground.com/auth.xhtml");
		page.click("//span[@class='ui-button-text ui-c']");
		
		
		
		
	}

}
