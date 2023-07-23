package week3.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReadConsoleMessages {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();

		page.onConsoleMessage(handler -> {
			String text = handler.text();
			//System.out.println(text);
			String type = handler.type();
			if(type.equals("log")) {
			String url = page.url();
			System.out.println(url);
			System.out.println(type+":::"+text);
			}
		});
		page.navigate("https://www.geeksforgeeks.org/");
		page.navigate("https://www.amazon.in/");
		page.type("#twotabsearchtextbox", "bags");
		page.keyboard().press("Enter");

	}

}
