package week3.day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnBrowserContext {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context1 = browser.newContext();
		BrowserContext context2 = browser.newContext();
		BrowserContext context3 = browser.newContext();
		Page page1 = context1.newPage();
		Page page2 = context2.newPage();
		Page page3 = context3.newPage();
		
		page1.navigate("https://leafground.com/window.xhtml");
		page2.navigate("https://www.amazon.in/");
		page3.navigate("https://www.flipkart.com/");

	}

}
