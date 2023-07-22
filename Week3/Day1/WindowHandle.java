package week3.day1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowHandle {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://leafground.com/window.xhtml");
		//Click Open
		page.click("//h5[contains(text(),'Click')]/following::span[1]");

		//To handle the window
		Page childPage = context.waitForPage(() ->{
			page.isVisible("text=Resolution Center");
		});
		//To enter the email on the new window
		childPage.type("input#email", "hello@testleaf.com");
		//System.out.println(childPage);

		//To handle multiple windows
		page.click("//h5[contains(text(),'opened tabs')]/following::span[1]");
		List<Page> pages = page.context().pages();
		//pages.get(0)
		Page webPage = null;
		for (Page window : pages) {
			if(window.title().equals("Web Table")) {
				webPage = window;
			}
			webPage.type("//input[@placeholder='Search']", "Amy");

			
		}
	}
}
