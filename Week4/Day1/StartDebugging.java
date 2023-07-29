package week4.day1;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class StartDebugging {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().connectOverCDP("http://localhost:9222");
		List<BrowserContext> contexts = browser.contexts();
		BrowserContext context = contexts.get(0);
		List<Page> pages = context.pages();
		System.out.println(pages.size());
		Page page = context.pages().get(0);
		String title = page.title();
		System.out.println(title);
		String url = page.url();
		System.out.println(url);
		//page.click("text=CRM/SFA");
		page.click("text=Create Lead");
		
	}

}
