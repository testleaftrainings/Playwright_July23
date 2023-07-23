package week3.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.TypeOptions;
import com.microsoft.playwright.Playwright;

public class Keyboard_Actions {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		page.type("#username", "Demosalesmanager", new Page.TypeOptions().setDelay(100));
		page.keyboard().press("Tab");
		
		String attribute = page.locator("*:focus").getAttribute("name");
		System.out.println(attribute);
		//page.type("#password", "crmsfa");
		
	}

}
